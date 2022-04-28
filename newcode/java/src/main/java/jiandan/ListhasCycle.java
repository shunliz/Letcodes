package jiandan;
/**
描述
        判断给定的链表中是否有环。如果有环则返回true，否则返回false。

        数据范围：链表长度 0 \le n \le 100000≤n≤10000，链表中任意节点的值满足 |val| <= 100000∣val∣<=100000
        要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)

        输入分为两部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。-1代表无环，其它的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编程时读入的是链表的头节点。

        例如输入{3,2,0,-4},1时，对应的链表的入口结点为从头结点开始的第1个结点（注：头结点为第0个结点），所以输出true。
 https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class ListhasCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while(p!=null&&p.next!=null){
            p = p.next.next;
            q = q.next;
            if(p == q){
                return true;
            }
        }
        return false;
    }
}
