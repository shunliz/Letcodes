package data_structures;


import java.util.HashMap;
import java.util.LinkedHashMap;

class ObjFlag {
    private volatile boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}

public class UnSeenTest {
    //简单变量，线程直接拷贝到线程本地副本，改变值，只改变线程副本，不影响其他线程
    //复杂类型，线程栈拷贝，只拷贝引用地址，内容改变，其他线程可以看到，也是为什么需要线程同步的原因。
    //private static boolean isRunning = true;
    public static void main(String[] args) throws InterruptedException {
        HashMap<String,String> map = new LinkedHashMap();
        System.out.println(Thread.currentThread().getPriority());
        map.put("k1","v1");
        new Thread(()->{
            System.out.println("thread start");
            System.out.println(Thread.currentThread().getPriority());
            while(true||!map.isEmpty()){
                System.out.println(map.isEmpty());
                //如果不sleep,主线程就得不到执行的机会。map 也不会被移除，主线程也不会结束，程序整个也不会结束。
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("end");
        }).start();

        Thread.sleep(1000);
        map.remove("k1");
        System.out.println("main thread done");
        return;
    }
}
