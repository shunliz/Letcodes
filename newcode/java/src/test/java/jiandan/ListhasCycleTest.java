package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListhasCycleTest {

    private static ListhasCycle test;

    @BeforeAll
    public static void init(){
        test = new ListhasCycle();
    }

    @Test
    void hasCycle1() {
        int[] arr = new int[] {3,2,0,4};
        ListNode head = null;
        ListNode temp = null;
        for(int num : arr){
            ListNode node = new ListNode(num);
            if(head == null){
                head = node;
                temp = node;
            }else{
                temp.next = node;
                temp = temp.next;
            }
        }

        temp.next = head.next;

        assertEquals(true, test.hasCycle(head));
    }

    @Test
    void hasCycle2() {
        int[] arr = new int[] {1};
        ListNode head = null;
        ListNode temp = null;
        for(int num : arr){
            ListNode node = new ListNode(num);
            if(head == null){
                head = node;
                temp = node;
            }else{
                temp.next = node;
                temp = temp.next;
            }
        }

        assertEquals(false, test.hasCycle(head));
    }

    @Test
    void hasCycle3() {
        int[] arr = new int[] {-1,-7,7,-4,19,6,-9,-5,-2,-5};
        ListNode head = null;
        ListNode temp = null;
        for(int num : arr){
            ListNode node = new ListNode(num);
            if(head == null){
                head = node;
                temp = node;
            }else{
                temp.next = node;
                temp = temp.next;
            }
        }

        temp.next = head.next.next.next.next.next.next;

        assertEquals(true, test.hasCycle(head));
    }

    @Test
    void hasCycle4() {
        int[] arr = new int[] {1,2};
        ListNode head = null;
        ListNode temp = null;
        for(int num : arr){
            ListNode node = new ListNode(num);
            if(head == null){
                head = node;
                temp = node;
            }else{
                temp.next = node;
                temp = temp.next;
            }
        }

        assertEquals(false, test.hasCycle(head));
    }
}