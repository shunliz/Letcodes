package jiandan;

/**
 * 描述
 * 有一棵有\mathit nn个节点的二叉树，其根节点为\mathit rootroot。修剪规则如下:
 * 1.修剪掉当前二叉树的叶子节点，但是不能直接删除叶子节点
 * 2.只能修剪叶子节点的父节点，修剪了父节点之后，叶子节点也会对应删掉
 * 3.如果想在留下尽可能多的节点前提下，修剪掉所有的叶子节点。请你返回修剪后的二叉树。
 *
 * https://www.nowcoder.com/practice/39b559fb84864bde93eccd6e87312650?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */

public class TreePruneLeaves {

    public TreeNode pruneLeaves (TreeNode root) {
        // write code here
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return null;
        }
        TreeNode left =null, right=null;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                return null;
            }
            left = pruneLeaves(root.left);
        }
        if(root.right != null){
            if(root.right.left == null && root.right.right == null){
                return null;
            }
            right = pruneLeaves(root.right);
        }

        root.left = left;
        root.right = right;
        return root;
    }

}
