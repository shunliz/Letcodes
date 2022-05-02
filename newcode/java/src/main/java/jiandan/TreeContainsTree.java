package jiandan;

/**
 *描述
 * 给定彼此独立的两棵二叉树，树上的节点值两两不同，判断 t1 树是否有与 t2 树完全相同的子树。
 *
 * 子树指一棵树的某个节点的全部后继节点
 *
 * 数据范围：树的节点数满足 0<n≤500000，树上每个节点的值一定在32位整型范围内
 * 进阶：空间复杂度: O(1)O(1)，时间复杂度 O(n)O(n)
 *
 * https://www.nowcoder.com/practice/4eaccec5ee8f4fe8a4309463b807a542?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class TreeContainsTree {
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        if(root1==null){
            return false;
        }
        return isContains(root1.left,root2) || isContains(root1.right,root2) || isSubTree(root1,root2);
    }

    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }
        return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
    }
}
