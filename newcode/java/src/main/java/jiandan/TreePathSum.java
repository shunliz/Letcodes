package jiandan;

/**
 *描述
 * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 *
 * 例如：
 * 给出如下的二叉树， sum=22，
 *
 * 返回true，因为存在一条路径5→4→11→2的节点值之和为 22
 *
 * 数据范围：
 * 1.树上的节点数满足 0≤n≤10000
 * 2.每 个节点的值都满足 val≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 进阶：空间复杂度 O(树的高度)O(树的高度)，时间复杂度 O(n)O(n)
 *
 * https://www.nowcoder.com/practice/508378c0823c423baa723ce448cbfd0c?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val){
        this.val = val;
    }
}

public class TreePathSum {

    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root == null){
            return false;
        }

        Integer val = root.val;
        if(root.left == null && root.right == null && sum == val){
            return true;
        }

        return hasPathSum(root.left,sum-val) || hasPathSum(root.right,sum-val);
    }
}
