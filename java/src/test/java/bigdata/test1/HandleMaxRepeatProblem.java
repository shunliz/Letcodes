package bigdata.test1;


import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc:
 * @Author: bingbing
 * @Date: 2022/5/4 0004 19:19
 * 多线程处理
 */
public class HandleMaxRepeatProblem {

    public static final int start = 18;
    public static final int end = 70;

    public static final String dir = "D:\\dataDir";

    public static final String FILE_NAME = "D:\\User.dat";

    private static final int threadNums = 20;


    /**
     * key 为年龄，  value为所有的行列表，使用队列
     */
    private static Map<Integer, Vector<String>> valueMap = new ConcurrentHashMap<>();


    /**
     * 存放数据的队列
     */
    private static List<LinkedBlockingQueue<String>> blockQueueLists = new LinkedList<>();


    /**
     * 统计数量
     */
    private static Map<String, AtomicInteger> countMap = new ConcurrentHashMap<>();


    private static Map<Integer, ReentrantLock> lockMap = new ConcurrentHashMap<>();

    // 队列负载均衡
    private static AtomicLong count = new AtomicLong(0);

    /**
     * 开启消费的标志
     */
    private static volatile boolean startConsumer = false;

    /**
     * 消费者运行保证
     */
    private static volatile boolean consumerRunning = true;


    /**
     *  init map
     */

    static {

        //每个队列容量为256
        for (int i = 0; i < threadNums; i++) {
            blockQueueLists.add(new LinkedBlockingQueue<>(256));
        }


        for (int i = start; i <= end; i++) {
            countMap.computeIfAbsent(i + "", integer -> new AtomicInteger(0));
        }
    }

    public static void main(String[] args) {


        new Thread(() -> {
            try {
                // 读取数据
                readData();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }).start();

        new Thread(() -> {
            try {
                // 开始消费
                startConsumer();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            // 监控
            monitor();
        }).start();


    }


    /**
     * 每隔60s去检查栈是否为空
     */
    private static void monitor() {
        AtomicInteger emptyNum = new AtomicInteger(0);
        while (consumerRunning) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (startConsumer) {
                // 如果所有栈的大小都为0，那么终止进程
                AtomicInteger emptyCount = new AtomicInteger(0);
                for (int i = 0; i < threadNums; i++) {
                    if (blockQueueLists.get(i).size() == 0) {
                        emptyCount.getAndIncrement();
                    }
                }
                if (emptyCount.get() == threadNums) {
                    emptyNum.getAndIncrement();
                    // 如果连续检查指定次数都为空，那么就停止消费
                    if (emptyNum.get() > 12) {
                        consumerRunning = false;
                        System.out.println("消费结束...");
                        try {
                            clearTask();
                        } catch (Exception e) {
                            System.out.println(e.getCause());
                        } finally {
                            System.exit(-1);
                        }
                    }
                }
            }

        }
    }


    private static void readData() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME), "utf-8"));
        String line;
        long start = System.currentTimeMillis();
        int count = 1;
        while ((line = br.readLine()) != null) {
            // 按行读取，并向队列写入数据
            long index = count % threadNums;
            try {
                // 如果满了就阻塞
                blockQueueLists.get((int) index).put(line);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count % 100 == 0) {
                System.out.println("读取100行,总耗时间: " + (System.currentTimeMillis() - start) / 1000 + " s");
                try {
                    Thread.sleep(1000L);
                    System.gc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
        }

        br.close();
    }

    private static void clearTask() {
        // 清理，同时找出出现字符最大的数
        PriorityQueue<Map.Entry<String, AtomicInteger>> pq = new PriorityQueue<>(10, new Comparator<Map.Entry<String, AtomicInteger>>() {
            @Override
            public int compare(Map.Entry<String, AtomicInteger> o1, Map.Entry<String, AtomicInteger> o2) {
                // 最大堆用o2 - o1，最小堆用o1 - o2
                AtomicInteger ov2 = o2.getValue();
                AtomicInteger ov1 = o1.getValue();
                return ov1.get() - ov2.get();
            }
        });
        Iterator<Map.Entry<String, AtomicInteger>> entrySetIterator = countMap.entrySet().iterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<String, AtomicInteger> entry = entrySetIterator.next();
            if(pq.size() <10){
                pq.add(entry);
            }else{
                Map.Entry<String, AtomicInteger> e = pq.peek();
                if(entry.getValue().get()>e.getValue().get()){
                    pq.poll();
                    pq.add(entry);
                }
            }

        }

        while(!pq.isEmpty()){
            Map.Entry<String, AtomicInteger> entry = pq.poll();
            String key = (String)entry.getKey();
            AtomicInteger value = (AtomicInteger)entry.getValue();
            System.out.println("数量最多的年龄为:" + key + "数量为：" + value.get());
        }

        System.exit(-1);
    }

    /**
     * 使用linkedBlockQueue
     *
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    private static void startConsumer() throws FileNotFoundException, UnsupportedEncodingException {
        //如果共用一个队列，那么线程不宜过多，容易出现抢占现象
        System.out.println("开始消费...");
        for (int i = 0; i < threadNums; i++) {
            final int index = i;
            // 每一个线程负责一个queue，这样不会出现线程抢占队列的情况。
            new Thread(() -> {
                while (consumerRunning) {
                    startConsumer = true;
                    try {
                        String str = blockQueueLists.get(index).take();
                        countNum(str);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


    }

    // 按照arr的大小，运用多线程分割字符串
    private static void countNum(String str) {
        String[] strArray = str.split(",");
        for (String s : strArray) {
            countMap.computeIfAbsent(s, s1 -> new AtomicInteger(0)).getAndIncrement();
        }
    }

}
