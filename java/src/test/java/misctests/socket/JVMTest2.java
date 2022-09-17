package misctests.socket;



import java.util.LinkedList;

public class JVMTest2 {
    public static void test2() throws InterruptedException {
        Thread.sleep(20000); // 这个睡眠是为了方便执行jstat命令
        for (int i = 0; i < 1000; i++) {
            // 400kb的toOldForAge常驻内存，当YGC超过15次时，toOld会进入老年代
            // toOldForAge对象大小肯定是比400kb要大的，400kb是纯粹的数据的大小
            LinkedList toOldForAge = new LinkedList();
            for(int i1 = 0;i<400*1024;i++){
                toOldForAge.add(new Integer(2));
            }
            for (int j = 0; j < 1000; j++) {
                Thread.sleep(100);
                // 一个int占4个字节，数组纯数据大小为 4*200*1024 = 800kb大小 大约0.8兆
                // 年轻代大小为100m，按照8:1:1的比例，那么80m的内存最多能存102个arr对象
                int[] arr = new int[200 * 1024];
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        test2();
    }
}
