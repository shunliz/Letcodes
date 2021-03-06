package data_structures;


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

            // ??????
            public synchronized void purchase() {
                // ?????????????????????????????????1?????????
                while (product > 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + "?????????");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // ignore exception
                    }
                }
                ++product;
                // ????????????while????????????????????????????????????
                System.out.println(Thread.currentThread().getName() + ": " + "-------------????????????????????????" + product);
                this.notifyAll();
            }

            // ??????
            public synchronized void outbound() {
                while (product <= 0) {
                    System.out.println(Thread.currentThread().getName() + ": " + "???????????????????????????");
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        // ignore exception
                    }
                }
                --product;
                System.out.println(Thread.currentThread().getName() + ":????????????????????????" + product);
                this.notifyAll();
            }
        }

        // ?????????
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

        // ?????????
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
        // ???3???????????????
        // final CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread("thread-1") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "??????????????????5???");
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "??????????????????");
            }
        }.start();
        new Thread("thread-2") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "????????????");
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "??????????????????");
            }
        }.start();

        countDownLatch.await();
        System.out.println("?????????????????????");
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
                    barrier.await();
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
                 * workerLeader????????????worker?????????????????????CyclicBarrier?????????????????????????????????????????????????????????
                 * ????????????(??????????????????????????????????????????????????????barrier???await??????)??????????????????runnable???
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
         * ?????????barrier??????????????????????????????????????????barrier???????????????await???????????????????????????????????????????????????await??????????????????????????????
         * ??????????????????CycliBarrier??????????????????????????????
         * ??????????????????????????????????????????????????????worker?????????????????????worker??????await??????????????????????????????WorkerLeader????????????
         * ????????????barrier???????????????????????????latch???,?????????????????????worker???????????????WorkerLeader?????????????????????????????????
         * ???????????????ConcurrentHashMap,??????????????????????????????????????????????????????????????????future???
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
        // ????????????????????????????????????
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        // ????????????????????????
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
        //??????task?????????????????????????????????????????????????????????????????????????????????
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
        //??????????????????????????????????????????????????????????????????
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

}


