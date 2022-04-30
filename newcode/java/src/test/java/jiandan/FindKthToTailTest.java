package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindKthToTailTest {
    private static FindKthToTail test;

    @BeforeAll
    public static void init(){
        test = new FindKthToTail();
    }

    @Test
    void findKthToTail() {
        Integer[] arr = {1,2,3,4,5};
        Integer[] exp = {4,5};
        ListNode pHead = getListFromArray(arr);
        Integer[] res = getArrayFromList(test.FindKthToTail(pHead,2));
        assertArrayEquals(exp, res);
    }

    private Integer[] getArrayFromList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head !=null){
            list.add(head.val);
            head = head.next;
        }
        return list.toArray(new Integer[]{});
    }

    private ListNode getListFromArray(Integer[] arr) {
        ListNode pHead = null;
        ListNode q = null;
        for(int num: arr){
            ListNode node = new ListNode(num);
            if(pHead == null){
                pHead = node;
                q = node;
            }else{
                q.next = node;
                q = q.next;
            }
        }
        return pHead;
    }

    @Test
    void findKthToTail2() {
        Integer[] arr = {2};
        Integer[] exp = {};
        ListNode pHead = getListFromArray(arr);
        Integer[] res = getArrayFromList(test.FindKthToTail(pHead,8));
        assertArrayEquals(exp, res);
    }
}