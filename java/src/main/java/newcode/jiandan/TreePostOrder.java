package newcode.jiandan;

import newcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述
 * 给定一个二叉树，返回他的后序遍历的序列。
 *
 * 后序遍历是值按照 左节点->右节点->根节点 的顺序的遍历。
 *
 * 数据范围：二叉树的节点数量满足 0≤n≤100  ，二叉树节点的值满足 1≤val≤100  ，树的各节点的值各不相同
 * https://www.nowcoder.com/practice/1291064f4d5d4bdeaefbf0dd47d78541?tpId=117&tqId=39367&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */

public class TreePostOrder {

    public int[] postorderTraversal (TreeNode root) {
        // write code here
        if(root == null){
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.left != null){
                s.push(node.left);
            }
            if(node.right != null){
                s.push(node.right);
            }
            res.add(0,node.val);
        }
        int[] ret = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
}
