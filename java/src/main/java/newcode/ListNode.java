package newcode;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
        next = null;
    }

    public Integer[] toArray(){
        ListNode indx = this;
        List<Integer> res = new LinkedList<Integer>();
        while(indx != null){
            res.add(indx.val);
            indx = indx.next;
        }

        return res.toArray(new Integer[] {});
    }
}
