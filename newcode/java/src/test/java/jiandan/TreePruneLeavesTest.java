package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreePruneLeavesTest {

    private static TreePruneLeaves test;

    @BeforeAll
    public static void init(){
        test = new TreePruneLeaves();
    }

    @Test
    void pruneLeaves() {
        int[] arr = {1,1,1,1,1,1,1};
        int[] exp = {1};
        TreeNode treeNode = TreeNode.getTreeFromArray(arr);
        TreeNode res = test.pruneLeaves(treeNode);
        assertArrayEquals(exp, TreeNode.getArrayFromTree(res));
    }

    @Test
    void pruneLeaves2() {
        int[] arr = {1,Integer.MIN_VALUE,1,Integer.MIN_VALUE,1,Integer.MIN_VALUE,1};
        int[] exp = {1,Integer.MIN_VALUE,1,Integer.MIN_VALUE,1};
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(1);
        root.right = r1;
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;
        TreeNode res = test.pruneLeaves(root);
        assertArrayEquals(exp, TreeNode.getArrayFromTree(res));
    }
}