package newcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val){
        this.val = val;
    }

    public static int[] getArrayFromTree(TreeNode root) {
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
            }else if(nd.right !=null){
                arrayList.add(Integer.MIN_VALUE);
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

    public static TreeNode getTreeFromArray(int[] arr) {
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> quque = new LinkedList<TreeNode>();
        quque.offer(root);
        int indx = 1;
        while(!quque.isEmpty()){
            TreeNode nd = quque.poll();
            if(nd == null){
                continue;
            }
            TreeNode temp2 = null;
            TreeNode temp = null;
            if(indx<arr.length){
                int lval = arr[indx++];
                if(lval != Integer.MIN_VALUE){
                    temp = new TreeNode(lval);
                }
                nd.left = temp;
                quque.offer(temp);
            }
            if(indx<arr.length){
                int rval = arr[indx++];
                if(rval != Integer.MIN_VALUE){
                    temp2 = new TreeNode(rval);
                }
                nd.right = temp2;
                quque.offer(temp2);
            }

        }
        return root;
    }
}
