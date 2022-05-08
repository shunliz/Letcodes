package newcode.jiandan;

import newcode.TreeNode;

import java.util.Arrays;

/**
 * 给定一个升序排序的数组，将其转化为平衡二叉搜索树（BST）.
 *
 * 平衡二叉搜索树指树上每个节点 node 都满足左子树中所有节点的的值都小于 node 的值，右子树中所有节点的值都大于 node 的值，并且左右子树的节点数量之差不大于1
 *
 * 数据范围：0≤n≤10000，数组中每个值满足 val≤5000
 * 进阶：空间复杂度 O(n)O(n) ，时间复杂度 O(n)O(n)
 *
 *https://www.nowcoder.com/practice/7e5b00f94b254da599a9472fe5ab283d?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST (int[] num) {
        // write code here
        if(num.length == 0){
            return null;
        }
        if(num.length == 1){
            return new TreeNode(num[0]);
        }
        int mid = num.length/2;
        TreeNode root = new TreeNode(num[mid]);
        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(num,0,mid));
        TreeNode right = sortedArrayToBST(Arrays.copyOfRange(num,mid+1,num.length));
        root.left = left;
        root.right = right;
        return root;
    }
}
