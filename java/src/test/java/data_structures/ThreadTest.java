package data_structures;


import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;


public class ThreadTest {
    private volatile boolean flag = false;
    @Test
    void guitusaipao() throws InterruptedException {

        class TuZi extends Thread {
            private int dist;
            public TuZi(int dist){
                this.dist = dist;
            }
            private int runedsteps = 0;
            public int getRunedsteps() {
                return runedsteps;
            }
            @Override
            public void run() {
                while(flag != true){
                    Random rand = new Random();
                    int sts = rand.nextInt(20);
                    runedsteps+=sts;
                    System.out.println("TuZi run to "+runedsteps);
                    if(runedsteps >= this.dist){
                        System.out.println("tuzi win, game over.");
                        flag = true;
                        break;
                    }
                    try {
                        Thread.sleep(10);
                        Thread.sleep(rand.nextInt(20));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class WuGui extends Thread {
            private int dist;
            public WuGui(int dist){
                this.dist = dist;
            }

            public int getRunedsteps() {
                return runedsteps;
            }

            private int runedsteps = 0;
            @Override
            public void run() {
                while(flag != true){
                    Random rand = new Random();
                    int sts = rand.nextInt(10);
                    runedsteps+=sts;
                    System.out.println("WuGui run to "+runedsteps);
                    if(runedsteps >= this.dist){
                        System.out.println("WuGui win, game over.");
                        flag = true;
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class Race extends  Thread {
            @Override
            public void run() {
                TuZi tuZi = new TuZi(300);
                WuGui wuGui = new WuGui(300);
                tuZi.start();
                wuGui.start();
                while(flag != true){
                    if(tuZi.getState().compareTo(State.TIMED_WAITING) == 0){
                        System.out.println("tuzi is sleeping");
                    }
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Race race = new Race();
        race.start();
        race.join();

    }

    @Test
    void threadfalsewakeup() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(4);
        class WareHouse {
            private volatile int product = 0;

            // 入库
            public synchronized void purchase() {
                // 库存已满，仓库最多容纳1个货品
                while (product > 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + "已满！");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // ignore exception
                    }
                }
                ++product;
                // 该线程从while中出来的时候，已满足条件
                System.out.println(Thread.currentThread().getName() + ": " + "-------------入库成功，余货：" + product);
                this.notifyAll();
            }

            // 出库
            public synchronized void outbound() {
                while (product <= 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + "库存不足，无法出库");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // ignore exception
                    }
                }
                --product;
                System.out.println(Thread.currentThread().getName() + ":出库成功，余货：" + product);
                this.notifyAll();
            }
        }

        // 生产者
        class Producer implements Runnable {
            private WareHouse wareHouse;

            public Producer(WareHouse wareHouse) {
                this.wareHouse = wareHouse;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; ++i) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }
                    wareHouse.purchase();
                }
                countDownLatch.countDown();
            }
        }

        // 消费者
        class Customer implements Runnable {
            private WareHouse wareHouse;

            public Customer(WareHouse wareHouse) {
                this.wareHouse = wareHouse;
            }

            @Override
            public void run() {
                for (int i = 0; i < 5; ++i) {
                    wareHouse.outbound();
                }
                countDownLatch.countDown();
            }
        }

        WareHouse wareHouse = new WareHouse();
        Producer producer = new Producer(wareHouse);
        Customer customer = new Customer(wareHouse);

        new Thread(producer, "ProducerA").start();
        new Thread(producer, "ProducerB").start();

        new Thread(customer, "ConsumerC").start();
        new Thread(customer, "ConsumerD").start();
        countDownLatch.await();

    }

    @Test
    void testcountdownlatch() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        // 为3时一直等待
        // final CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread("thread-1") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "读取文件需要5秒");
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "读取文件结束");
            }
        }.start();
        new Thread("thread-2") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "读取文件");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "读取文件结束");
            }
        }.start();

        countDownLatch.await();
        System.out.println("所有任务执行完");
    }

    @Test
    void testbarrier() throws InterruptedException {
        class Worker implements Runnable {
            private CyclicBarrier barrier;
            private int workerId;
            private ConcurrentHashMap<Integer, Integer> concurrentHashMap;

            public Worker(CyclicBarrier barrier, int workerId, ConcurrentHashMap<Integer, Integer> concurrentHashMap) {
                this.barrier = barrier;
                this.workerId = workerId;
                this.concurrentHashMap = concurrentHashMap;
            }

            @Override
            public void run() {
                try {
                    int sleepTime = new Random().nextInt(3000);
                    System.out.println(workerId + " is working...");
                    Thread.sleep(sleepTime);
                    concurrentHashMap.put(workerId, sleepTime);
                    barrier.await();//在业务行之前，则是等待所有线程都准备好，一块开始。
                                   // 在业务执行之后，则是等待所有线程执行结束后，一块结束执行。
                    System.out.println(workerId + "with time " + sleepTime + " finish");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        class WorkerLeader implements Runnable {
            private ConcurrentHashMap<Integer, Integer> concurrentHashMap;
            private final List<Integer> workerIdList;

            public WorkerLeader(ConcurrentHashMap<Integer, Integer> concurrentHashMap, List<Integer> workerIdList) {
                this.concurrentHashMap = concurrentHashMap;
                this.workerIdList = workerIdList;
            }

            @Override
            public void run() {
                /**
                 * workerLeader执行实在worker执行之后，因为CyclicBarrier构造函数的第二个参数代表着栅栏中的线程
                 * 都到达后(这里的到达其实就是说最后一个线程调用barrier的await之后)，才会执行的runnable。
                 *
                 */
                System.out.println("=====last batch is ok ......");
                for (Integer workerId : workerIdList) {
                    System.out.println("workerId is:" + workerId + " ,executeTime is:" + concurrentHashMap.get(workerId));
                }
            }

        }

        int Worker_Count = 9;
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        List<Integer> workIds = new ArrayList<>();
        for (int i = 0; i < Worker_Count; i++) {
            workIds.add(i);
        }
        /**
         * 这里的barrier构造函数指定了两个内容一个是barrier的执行线程await的个数，另一个是当最后一个线程满足await后，要执行什么动作。
         * 具体可以参考CycliBarrier的构造函数中的说明。
         * 这里简单介绍一下，就是说，当最后一个worker，也就是第三个worker执行await的时候，那么就会触发WorkerLeader的动作。
         * 同时由于barrier是可多次的（相比于latch）,所以可以有多个worker执行，但是WorkerLeader每次只取三个进行操作。
         * 这边使用了ConcurrentHashMap,作为多个线程间共享数据的方式，当然，也可以用future。
         */
        CyclicBarrier barrier = new CyclicBarrier(3, new WorkerLeader(concurrentHashMap, workIds));
        for (int i = 0; i < Worker_Count; i++) {
            new Thread(new Worker(barrier, i, concurrentHashMap)).start();
        }


        Thread.sleep(10000);
    }

    @Test
    void testsequencerun() throws InterruptedException {

        class Work implements Runnable{
            private Thread beforeThread;
            public Work(Thread beforeThread){
                this.beforeThread = beforeThread;
            }

            @Override
            public void run() {
                if(beforeThread != null){
                    try{
                        beforeThread.join();
                        System.out.println("thread start:"+Thread.currentThread());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("thread start:"+Thread.currentThread());
                }
            }
        }
        Thread t1 = new Thread(new Work(null));
        Thread t2 = new Thread(new Work(t1));
        Thread t3 = new Thread(new Work(t2));
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);

    }

    @Test
    void testsequencerun2() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start : " + Thread.currentThread().getName() + " run one");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start : " + Thread.currentThread().getName() + " run two");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread start : " + Thread.currentThread().getName() + " run three");
            }
        });

        ExecutorService executor = Executors.newSingleThreadExecutor();
        // 将线程依次加入到线程池中
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        // 及时将线程池关闭
        executor.shutdown();
    }

    @Test
    void testsequencerun3(){
        class Work implements Runnable{
            @Override
            public void run() {
                System.out.println("thread start : " + Thread.currentThread().getName());
            }
        }
        Thread t1 = new Thread(new Work());
        Thread t2 = new Thread(new Work());
        Thread t3 = new Thread(new Work());

        CompletableFuture.runAsync(()-> t1.start())
                .thenRun(()->t2.start())
                .thenRun(()->t3.start());
    }

    //lock and condition
    @Test
    void testsequencelooprun1(){
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        class MyTask extends Thread{
            private String flag;
            public MyTask(String flag){
                this.flag = flag;
            }
            @Override
            public void run() {
                execute(flag);
            }

            private void execute(String flag) {
                lock.lock();
                for(int i=0;i<10;i++){
                    if("A".equalsIgnoreCase(flag)){
                        print(flag, conditionA,conditionB);
                    }
                    if("B".equalsIgnoreCase(flag)){
                        print(flag, conditionB,conditionC);
                    }
                    if("C".equalsIgnoreCase(flag)){
                        print(flag, conditionC,conditionA);
                    }
                }
                lock.unlock();
            }

            private void print(String name, Condition currentThread, Condition nextThread) {
                try{
                    System.out.println(Thread.currentThread().getName()  + "-" + name);
                    nextThread.signal();
                    currentThread.await();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        Thread t1 = new MyTask("A");
        Thread t2 = new MyTask("B");
        Thread t3 = new MyTask("C");
        t3.setPriority(3);
        t2.setPriority(2);
        t1.setPriority(1);
        t3.start();
        t2.start();
        t1.start();
    }

    //Semaphore
    @Test
    void testsequencelooprun2(){
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        class MyTask extends  Thread{
            private String name;
            private Semaphore cur;
            private Semaphore next;

            public MyTask(String name, Semaphore cur, Semaphore next){
                this.name = name;
                this.cur = cur;
                this.next = next;
            }

            @Override
            public void run() {
                print(name, cur, next);
            }

            private void print(String name, Semaphore currentSemaphore, Semaphore nextSemaphore)
            {
                for (int i = 0; i < 10; i++){
                    try {
                        currentSemaphore.acquire();
                        System.out.println(Thread.currentThread().getName() +" print "+ name);
                        nextSemaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        MyTask t1 = new MyTask("A", semaphoreA, semaphoreB);
        MyTask t2 = new MyTask("B", semaphoreB, semaphoreC);
        MyTask t3 = new MyTask("C", semaphoreC, semaphoreA);
        t1.start();
        t2.start();
        t3.start();
    }


    @Test
    void testatomatic() throws InterruptedException {
        final AtomicInteger value = new AtomicInteger(10);
        assertEquals(value.compareAndSet(1, 2), false);
        assertEquals(value.get(), 10);
        assertTrue(value.compareAndSet(10, 3));
        assertEquals(value.get(), 3);
        value.set(0);
        //
        assertEquals(value.incrementAndGet(), 1);
        assertEquals(value.getAndAdd(2),1);
        assertEquals(value.getAndSet(5),3);
        assertEquals(value.get(),5);
        Lock lock = new ReentrantLock();
        //
        final int threadSize = 10;
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                public void run() {
                    lock.lock();
                    value.incrementAndGet();
                    System.out.println(value.get());
                    lock.unlock();
                }
            };
        }
        //
        for(Thread t:ts) {
            t.start();
        }
        for(Thread t:ts) {
            t.join();
        }
        //
        assertEquals(value.get(), 5+threadSize);
    }

    @Test
    void testnotatomatic() throws InterruptedException {
        int ret = testnoatomatic();
        assertEquals(ret, 5+10);
    }

    @Test
    void testnotatomatic100() throws InterruptedException {
        int testcnt = 100;
        int[] arr = new int[testcnt];
        int[] exp = new int[testcnt];
        for(int k=0;k<testcnt;k++){
            exp[k] = 15;
        }
        for(int i=0;i<testcnt;i++){
            arr[i]=testnoatomatic();
        }
        int cnt =0;
        for(int i=0;i<testcnt;i++){
            if(arr[i] != 15){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private int testnoatomatic() throws InterruptedException {
        final int threadSize = 10;
        final Integer[] value = {5};
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                public void run() {
                    value[0]++;
                    //System.out.println(value[0]);
                }
            };
        }
        //
        for(Thread t:ts) {
            t.start();
        }
        for(Thread t:ts) {
            t.join();
        }
        //
        //assertEquals(value[0], 5+threadSize);
        return value[0];
    }

    @Test
    void testcountdownlatch2() throws InterruptedException {
        //所有task线程等待准备工作完成，准备工作完成后一起启动工作线程。
        int times = 10;
        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch overLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        startLatch.await();
                        //per thread prepare working
                        System.out.println(Thread.currentThread().getName()+" is preparing working..........");
                        System.out.println("task running its work........");
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    } finally {
                        overLatch.countDown();
                    }
                }
            }).start();
        }
        //这里准备任务的一些先决条件，然后启动工作任务
        System.out.println("preparing to start run work threads.........");
        long start = System.nanoTime();
        startLatch.countDown();
        overLatch.await();
        long ret = System.nanoTime() - start;
        System.out.println(ret);

    }

    @Test
    void testfunctionfunc(){
        Function function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };

        System.out.println(function.apply("asd"));

        Predicate<String> pre = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };

        System.out.println(pre.test("asd"));

        Supplier<String> sup = new Supplier<String>() {
            @Override
            public String get() {
                return "supp";
            }
        };

        System.out.println(sup.get());

        Consumer<String> cons = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        cons.accept("cons asd");
    }

    @Test
    void teststreamtt(){
        class User{
            private String name;
            private int age;
            public User(String name, int age){
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
        List<User> users = new ArrayList<User>();
        users.add(new User("user21", 21));
        users.add(new User("user31", 31));
        users.add(new User("user41", 41));
        users.add(new User("user51", 51));


        users.stream().filter(user ->{return user.age>23;})
                .map(u->{return u.name.toUpperCase();})
                .forEach(System.out::println);
    }

    @Test
    void completableFutureTest() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行step 1");
            queue.add("result1");
            return "result1";
        }, executor);
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行step 2");
            queue.add("result2");
            return "result2";
        });

        CompletableFuture<String> cf3 = cf1.thenApply(result1 -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行step 3");
            queue.add("result1->3");
            return result1;
        });
        CompletableFuture<String> cf5 = cf2.thenApply(result2 -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行step 5");
            queue.add("result2->5");
            return result2;
        });

        CompletableFuture<String> cf4 = cf1.thenCombine(cf2, (result1, result2) -> {
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行step 4");
            queue.add("result12->4");
            return result1+result2;
        });

        CompletableFuture<Void> cf6 = CompletableFuture.allOf(cf3, cf4, cf5);
        CompletableFuture<String> result = cf6.thenApply(v -> {
            //这里的join并不会阻塞，因为传给thenApply的函数是在CF3、CF4、CF5全部完成时，才会执行 。
            String result3 = cf3.join();
            String result4 = cf4.join();
            String result5 = cf5.join();
            queue.add("result345->6");
            //根据result3、result4、result5组装最终result;
            return result3+result4+result5;
        });
        String res = result.get();
        System.out.println(res);
    }

    @Test
    void completeableDeadLock() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ThreadPoolExecutor threadPool1 = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doGet(threadPool1);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doGet(threadPool1);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doGet(threadPool1);
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

    private Object doGet(ThreadPoolExecutor threadPool1) {

        CompletableFuture cf1 = CompletableFuture.supplyAsync(() -> {
            //do sth
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("child");
                return "child";
            }, threadPool1).join();//子任务
        }, threadPool1);
        return cf1.join();
    }


    @Test
    void testcounddownasCB() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Thread[] ths = new Thread[5];
        for(int i=0;i<5;i++){
            ths[i] = new Thread(()->{
                latch.countDown();
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"started");
            });
            ths[i].start();
            //ths[i].join();
        }
        latch.await();
        System.out.println("Main thread started");
    }

    @Test
    void countdownstartalgin() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread 大乔 = new Thread(() -> waitToFight(countDownLatch));
        Thread 兰陵王 = new Thread(() -> waitToFight(countDownLatch));
        Thread 安其拉 = new Thread(() -> waitToFight(countDownLatch));
        Thread 哪吒 = new Thread(() -> waitToFight(countDownLatch));
        Thread 铠 = new Thread(() -> waitToFight(countDownLatch));

        大乔.start();
        兰陵王.start();
        安其拉.start();
        哪吒.start();
        铠.start();
        Thread.sleep(1000);
        countDownLatch.countDown();
        System.out.println("敌方还有5秒达到战场，全军出击！");

    }

    private void waitToFight(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await(); // 在此等待信号再继续
            System.out.println("收到，发起进攻！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void countdownalldonestart() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Thread 大乔 = new Thread(countDownLatch::countDown);
        Thread 兰陵王 = new Thread(countDownLatch::countDown);
        Thread 安其拉 = new Thread(countDownLatch::countDown);
        Thread 哪吒 = new Thread(countDownLatch::countDown);
        Thread 铠 = new Thread(() -> {
            try {
                // 稍等，上个卫生间，马上到...
                Thread.sleep(1500);
                countDownLatch.countDown();
            } catch (InterruptedException ignored) {}
        });

        大乔.start();
        兰陵王.start();
        安其拉.start();
        哪吒.start();
        铠.start();
        countDownLatch.await();
        System.out.println("所有玩家已经就位！");

    }

    @Test
    void forkjointest() throws InterruptedException {
        class CountTask extends RecursiveTask<Integer> {
            private static final int THRESHOLD = 16; // 阈值
            private int start;
            private int end;

            public CountTask(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            protected Integer compute() {
                int sum = 0;
                // 如果任务足够小就计算任务
                boolean canCompute = (end - start) <= THRESHOLD;
                if (canCompute) {
                    for (int i = start; i <= end; i++) {
                        sum += i;
                    }
                } else {
                    // 如果任务大于阈值，就分裂成两个子任务计算
                    int middle = (start + end) / 2;
                    CountTask leftTask = new CountTask(start, middle);
                    CountTask rightTask = new CountTask(middle + 1, end);
                    // 执行子任务
                    leftTask.fork();
                    rightTask.fork(); // 等待子任务执行完，并得到其结果
                    int leftResult = leftTask.join();
                    int rightResult = rightTask.join(); // 合并子任务
                    sum = leftResult + rightResult;
                }
                try {
                    Thread.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return sum;
            }
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ForkJoinPool forkJoinPool = new ForkJoinPool(); // 生成一个计算任务，负责计算1+2+3+4
        CountTask task = new CountTask(1, 1000); // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
        stopWatch.stop();
        System.out.println(stopWatch.getNanoTime());

        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        int sum = 0;
        for(int i=0;i<1000;i++){
            sum +=i;
            //如果任务处理时间很短，比如简单的整数自加，ForkJoin并不比单线程循环快，因为存在线程切换开销。
            Thread.sleep(new Random().nextInt(10));
        }
        stopWatch2.stop();
        System.out.println(stopWatch2.getNanoTime());

    }

    @Test
    void testinheritableTHL(){
        final ThreadLocal threadLocal = new InheritableThreadLocal();
        // 主线程
        threadLocal.set("不擅技术");
        //子线程
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("鄙人三某 ，" + threadLocal.get());
            }
        };
        t.start();
    }

}


