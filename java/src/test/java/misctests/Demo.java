package misctests;

import io.netty.util.concurrent.NonStickyEventExecutorGroup;
import org.checkerframework.checker.units.qual.K;
import org.junit.platform.commons.util.LruCache;
import org.nustaq.net.TCPObjectServer;
import sun.misc.Unsafe;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue priorityBlockingQueue = new ArrayBlockingQueue(5);
        Thread producer = new Thread(()->{
            while(true){
                try {
                    Integer o = new Random().nextInt(100);
                    Thread.sleep(o);
                    priorityBlockingQueue.put(o);
                    System.out.println("produce:"+o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(()->{
            while(true){
                Integer o = new Random().nextInt(1000);
                try {
                    Thread.sleep(o);
                    Integer integer = (Integer)priorityBlockingQueue.take();
                    System.out.println("consume:"+integer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        producer.start();
        consumer.start();
        //producer.join();
        //consumer.join();
    }
}
