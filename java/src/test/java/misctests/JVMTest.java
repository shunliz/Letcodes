package misctests;

import java.util.LinkedList;
import java.util.Random;

public class JVMTest {
    public static void testsmall() throws InterruptedException {
        LinkedList list = new LinkedList();
        for(int i=0;i<1000;i++){
            Thread.sleep(new Random().nextInt(100));
            list.add(new Byte[10*1024]);
        }
    }
    public static void  framemethod() throws InterruptedException {
        LinkedList list = new LinkedList();
        for(int i=0;i<3*1024;i++){
            Thread.sleep(10);
            list.add(new Byte[250*1024]);
        }

        for(int i=0;i<40;i++){
            new Thread(()-> {
                try {
                    threadrun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    private static void threadrun() throws InterruptedException {
        for(int i=0;i<1000;i++){
            testsmall();
            Thread.sleep(new Random().nextInt(100));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        framemethod();
    }
}
