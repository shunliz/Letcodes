package newcode.jiandan;

import newcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 数据范围：二叉树的节点数 0 \le n \le 10000≤n≤1000 ， 二叉树每个节点的值 0\le val \le 10000≤val≤1000
 * 要求： 空间复杂度 O(n)O(n) 。本题也有原地操作，即空间复杂度 O(1)O(1) 的解法，时间复杂度 O(n)O(n)
 *
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class BinaryTreeMirror {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return null;
        }
        int[] mid = getArrayFromTree(pRoot);
        int[] mid2 = new int[mid.length];
        int indx = 1;
        int indx2 = 0;
        LinkedList<Integer> quque = new LinkedList<>();
        quque.offer(mid[0]);
        while(!quque.isEmpty()){
            for(int i=0,j=quque.size()-1;i<=j;i++,j--){
                int temp = quque.get(i);
                quque.set(i,quque.get(j));
                quque.set(j,temp);
            }
            int size = quque.size();
            for(int j=0;j<size;j++){
                Integer nd = quque.poll();
                mid2[indx2++] = nd;
                if(indx<mid.length){
                    quque.offer(mid[indx++]);
                }
                if(indx<mid.length){
                    quque.offer(mid[indx++]);
                }
            }
        }

        TreeNode res = getTreeFromArray(mid2);
        return res;
    }

    public TreeNode Mirror2 (TreeNode pRoot) {
        if(pRoot == null){
            return null;
        }
        TreeNode left = Mirror2(pRoot.left);
        TreeNode right = Mirror2(pRoot.right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

    public TreeNode Mirror3 (TreeNode pRoot) {
        //空树
        if(pRoot == null)
            return null;
        //辅助栈
        Stack<TreeNode> s = new Stack<TreeNode>();
        //根节点先进栈
        s.push(pRoot);
        while (!s.isEmpty()){
            TreeNode node = s.pop();
            //左右节点入栈
            if(node.left != null)
                s.push(node.left);
            if(node.right != null)
                s.push(node.right);
            //交换左右
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return pRoot;
    }


    public int[] getArrayFromTree(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        arrayList.add(root.val);
        while(!q.isEmpty()){
            TreeNode nd = q.poll();
            if(nd.left !=null){
                q.offer(nd.left);
                arrayList.add(nd.left.val);
            }
            if(nd.right !=null){
                q.offer(nd.right);
                arrayList.add(nd.right.val);
            }
        }
        int[] res = new int[arrayList.size()];
        for(int i=0;i<res.length;i++){
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public TreeNode getTreeFromArray(int[] arr) {
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> quque = new LinkedList<TreeNode>();
        quque.offer(root);
        int indx = 1;
        while(!quque.isEmpty()&&indx<arr.length){
            TreeNode nd = quque.poll();
            TreeNode temp = new TreeNode(arr[indx++]);
            TreeNode temp2 = new TreeNode(arr[indx++]);
            nd.left = temp;
            nd.right = temp2;
            quque.offer(temp);
            quque.offer(temp2);
        }
        return root;
    }

}
