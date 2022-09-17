package designpattern.singleton;

import java.util.concurrent.*;

public class SingletonApp {

    public static void main(String[] args) throws InterruptedException {
        Singleton1 singleton1 = Singleton1.getInstance();

        Singleton2 singleton2 = Singleton2.getInstance();

        Singleton3 singleton3 = Singleton3.getInstance();

        Singleton8 singleton8 = Singleton8.INSTANCE;

        Singleton3 s31 = Singleton3.getInstance();
        singleton8.whaterverMethod();
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100,200,
                20,TimeUnit.MILLISECONDS,workQueue, Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for(int i=0;i<50;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10;i++){
                        Singleton3 singleton31 = Singleton3.getInstance();
                        if(singleton31 != s31){
                            System.out.println("error occured..................");
                            break;
                        }
                        System.out.println(singleton31);
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        if(executor.awaitTermination(2, TimeUnit.MILLISECONDS)){
            executor.shutdown();
        }
    }

}
