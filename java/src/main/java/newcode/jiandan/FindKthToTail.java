package newcode.jiandan;

import newcode.ListNode;

/**
 * 描述
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *
 *
 * 数据范围：0≤n≤10^5，0≤ai≤10^9，0≤k≤10^9
 *
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * 例如输入{1,2,3,4,5},2时,返回倒数第2个结点（也即结点值为4的结点）即可，系统会打印后面所有的节点来比较。
 *
 * https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class FindKthToTail {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode p = pHead,q=pHead;
        int len = 0;
        while(p !=null){
            len++;
            p = p.next;
        }
        if(k>len){
            return null;
        }
        for(int i=0;i<len-k;i++){
            q = q.next;
        }
        return q;
    }
}
