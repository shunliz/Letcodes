package jiandan;

import newcode.jiandan.DeleteDuplicate;
import newcode.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteDuplicateTest {

    private static DeleteDuplicate test;

    @BeforeAll
    public static void init(){
        test = new DeleteDuplicate();
    }


    @Test
    void deleteDuplicates1() {
        int[] arr = {1,1,2};
        Integer[] exp = {1,2};
        ListNode pHead = getList(arr);
        ListNode res = test.deleteDuplicates(pHead);

        assertArrayEquals(exp, res.toArray());
    }

    @Test
    void deleteDuplicates2() {
        int[] arr = {};
        Integer[] exp = {};
        ListNode pHead = getList(arr);
        ListNode res = test.deleteDuplicates(pHead);

        assertEquals(null, res);
    }

    private ListNode getList(int[] arr) {
        ListNode pHead = null;
        ListNode indx = null;
        for(int num: arr){
            ListNode node = new ListNode(num);
            if(pHead == null){
                pHead = node;
                indx = node;
            }else{
                indx.next = node;
                indx = indx.next;
            }
        }
        return pHead;
    }
}