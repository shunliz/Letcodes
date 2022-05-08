package data_structures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapTest {

    private static MyHeap<Integer> test;

    @BeforeAll
    public static void init(){
        test = new MyHeap(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1-o2>0)?1:-1;
            }
        });
    }

    @Test
    void testAll(){
        int[] arr = {10, 4, 8, 3, 5, 1};
        for(int i=0;i<arr.length;i++){
            test.add(arr[i]);
        }

        assertEquals(6, test.size());

        Integer integer = test.remove();
        assertEquals(5, test.size());
        assertEquals(1, integer);

        Integer integer2 = test.peek();
        assertEquals(3, integer2);

        Integer[] res = test.toArray(new Integer[5]);
        Integer[] exp = {3,4,8,10,5};
        assertArrayEquals(exp, res);
    }

    @Test
    void testJdkHeap() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num1 - num2);
        int[] arr = {10, 4, 8, 3, 5, 1};
        for(int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
        }
    }

    @Test
    void size() {

    }

    @Test
    void remove() {

    }

    @Test
    void peek() {

    }

    @Test
    void toArray() {

    }
}