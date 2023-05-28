package newcode.zhongdeng;

import newcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListGetRandomTest {

    @Test
    void getRandom() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListGetRandom lgr = new ListGetRandom();
        int x = lgr.getRandom(head);
    }
}