package newcode.zhongdeng;

import newcode.TreeNode;

import java.util.ArrayList;
import java.util.Stack;


public class TreeTraverse {
    public int[][] threeOrders (TreeNode root) {
        // write code here
        ArrayList<Integer> preorder = preorder(root);
        ArrayList<Integer> midorder = midorder(root);
        ArrayList<Integer> postorder = postorder(root);
        int[][] res = new int[3][preorder.size()];
        for(int i=0;i<preorder.size();i++){
            res[0][i] = preorder.get(i);
            res[1][i] = midorder.get(i);
            res[2][i] = postorder.get(i);
        }
        return res;
    }

    private ArrayList<Integer> preorder(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            res.add(node.val);
            if(node.right !=null){
                s.push(node.right);
            }
            if(node.left != null){
                s.push(node.left);
            }
        }
        return res;
    }
    private ArrayList<Integer> midorder2(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }


    private ArrayList<Integer> midorder(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        s.push(root);
        while(!s.isEmpty() || p!=null){
            while(p!=null){
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            res.add(p.val);
            p = p.right;
        }
        return res;
    }

    private ArrayList<Integer> postorder(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(0, curr.val);
            if(curr.left != null) {
                stack.push(curr.left);
            }
            if(curr.right != null) {
                stack.push(curr.right);
            }
        }
        return res;
    }
}
