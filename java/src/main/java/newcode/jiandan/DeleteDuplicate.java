package newcode.jiandan;

import newcode.ListNode;

/**
 * 描述
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1,1,2,返回1,2.
 * 给出的链表为1,1, 2 , 3 ,返回1, 2 , 3.
 *
 * 数据范围：链表长度满足 0≤n≤100，链表中任意节点的值满足 val≤100
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79?tpId=117&tqId=37730&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */


public class DeleteDuplicate {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q!=null){
            if(p.val == q.val){
                p.next = q.next;
                q = q.next;
            }else{
                p = p.next;
                q = q.next;
            }
        }
        return head;
    }
}
