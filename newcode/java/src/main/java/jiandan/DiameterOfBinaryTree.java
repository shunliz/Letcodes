package jiandan;

/**
 * 描述
 * 给定一颗二叉树，求二叉树的直径。
 * 1.该题的直径定义为：树上任意两个节点路径长度的最大值
 * 2.该题路径长度定义为：不需要从根节点开始，也不需要在叶子节点结束，也不需要必须从父节点到子节点，一个节点到底另外一个节点走的边的数目
 * 3.这个路径可能穿过根节点，也可能不穿过
 * 4.树为空时，返回 0
 *
 * https://www.nowcoder.com/practice/15f977cedc5a4ffa8f03a3433d18650d?tpId=117&tqId=39370&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */


public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree (TreeNode root) {
        if(root == null)
            return 0;
        //求出左侧最大深度
        int left = dfs(root.left);
        //求出右侧最大深度
        int rigt = dfs(root.right);
        int res = left+rigt;
        return Math.max(Math.max(res,diameterOfBinaryTree(root.left)),diameterOfBinaryTree(root.right));

    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
}
