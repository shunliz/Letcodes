package jiandan;

/**
 *
 * 描述
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * 数据范围： n \le 1000n≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * 例如，输入{1,2,3},{4,5},{6,7}时，两个无环的单向链表的结构如下图所示：
 *
 * 可以看到它们的第一个公共结点的结点值为6，所以返回结点值为6的结点。
 * 输入描述：
 * 输入分为是3段，第一段是第一个链表的非公共部分，第二段是第二个链表的非公共部分，第三段是第一个链表和第二个链表的公共部分。 后台会将这3个参数组装为两个链表，并将这两个链表对应的头节点传入到函数FindFirstCommonNode里面，用户得到的输入只有pHead1和pHead2。
 * 返回值描述：
 * 返回传入的pHead1和pHead2的第一个公共结点，后台会打印以该节点为头节点的链表
 *
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=117&tqId=37761&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 *
 */
public class FirstCommonLinkNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p = pHead1;
        ListNode q = pHead2;
        while(p!=null){
            q = pHead2;
            while(q != null){
                if(p==q){
                    return p;
                }else {
                    q = q.next;
                }
            }
            p = p.next;
        }
        return null;
    }
}
