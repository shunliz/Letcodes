package newcode.jiandan;

import newcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 描述
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 数据范围：二叉树的节点数量满足 0 \le n \le 100 \0≤n≤100  ，二叉树节点的值满足 1 \le val \le 100 \1≤val≤100  ，树的各节点的值各不相同
 * https://www.nowcoder.com/practice/5e2135f4d2b14eb8a5b06fab4c938635?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */

public class TreePreOrder {
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        if(root == null){
            return new int[]{};
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.right != null){
                s.push(node.right);
            }
            if(node.left != null){
                s.push(node.left);
            }
            res.add(node.val);
        }
        int[] ret = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ret[i] = res.get(i);
        }
        return ret;
    }
}
