package misctests;
/*
import com.sun.org.apache.xml.internal.utils.XML11Char;
import sun.plugin.security.JDK11ClassFileTransformer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class ReorderingDemo {
    static int x = 0, y = 0, a = 0, b = 0;


    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10000; i++) {
            x=y=a=b=0;
            Thread one = new Thread() {
                public void run() {
                    a = 1;
                    x = b;
                }
            };
            Thread two = new Thread() {
                public void run() {
                    b = 1;
                    y = a;
                }
            };
            one.start();
            two.start();
            one.join();
            two.join();
            System.out.println(x + " " + y);
        }

    }

}
*/