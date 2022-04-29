package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class TreePathSumTest {
    private static TreePathSum test;

    @BeforeAll
    public static void init(){
        test = new TreePathSum();
    }

    @Test
    void hasPathSum() {
        Integer[] arr = {5,4,8,1,11,-1,9,-1,-1,2,7};
        TreeNode tree = getTree(arr);
        boolean res = test.hasPathSum(tree, 22);
        assertTrue(res);
    }

    private TreeNode getTree(Integer[] arr) {
        if(arr.length == 0){
            return null;
        }
        LinkedList<Integer> list = new LinkedList(Arrays.asList(arr));
        LinkedList<TreeNode> ts = new LinkedList<TreeNode>();
        Integer val = list.poll();
        TreeNode tree = new TreeNode(val);
        ts.offer(tree);
        while(true){
            if(ts.isEmpty()){
                break;
            }
            TreeNode node = ts.poll();
            TreeNode ln = null;
            TreeNode rn = null;
            if(!list.isEmpty()){
                int lval = list.poll();
                ln = lval == -1?null:new TreeNode(lval);
                if(node != null){
                    node.left = ln;
                }
                ts.offer(ln);
            }else{
                break;
            }
            if(!list.isEmpty()){
                int rval = list.poll();
                rn = rval == -1?null:new TreeNode(rval);
                if(node != null){
                    node.right = rn;
                }
                ts.offer(rn);
            }else{
                break;
            }
        }
        return tree;
    }

    @Test
    void hasPathSum1() {
        Integer[] arr = {1,2};
        TreeNode tree = getTree(arr);
        boolean res = test.hasPathSum(tree, 0);
        assertFalse(res);
    }

    @Test
    void hasPathSum2() {
        Integer[] arr = {1,2};
        TreeNode tree = getTree(arr);
        boolean res = test.hasPathSum(tree, 3);
        assertTrue(res);
    }

    @Test
    void hasPathSum3() {
        Integer[] arr = {};
        TreeNode tree = getTree(arr);
        boolean res = test.hasPathSum(tree, 0);
        assertFalse(res);
    }
}