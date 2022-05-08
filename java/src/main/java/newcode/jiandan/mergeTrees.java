package newcode.jiandan;

import newcode.TreeNode;

/**
 * 描述
 * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替
 *
 * https://www.nowcoder.com/practice/7298353c24cc42e3bd5f0e0bd3d1d759?tpId=117&tqId=37841&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */


public class mergeTrees {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        if(t1 !=null && t2!=null){
            t1.val = t1.val + t2.val;
        }
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        t1.left = left;
        t1.right = right;
        return t1;
    }
}
