package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TreeContainsTreeTest {

    private static TreeContainsTree test;

    @BeforeAll
    public static void init(){
        test = new TreeContainsTree();
    }

    @Test
    void isContains() {
        int[] parent = {1,2,3,4,5,6,7,Integer.MIN_VALUE,8,9};
        int[] child = {2,4,5,Integer.MIN_VALUE,8,9};
        TreeNode tp = TreeNode.getTreeFromArray(parent);
        TreeNode tc = TreeNode.getTreeFromArray(child);
        assertTrue(test.isContains(tp,tc));
    }

    @Test
    void isContains2() {
        int[] parent = {1,0,Integer.MIN_VALUE,-4,-3};
        int[] child = {1,Integer.MIN_VALUE,-4};
        TreeNode tp = TreeNode.getTreeFromArray(parent);
        TreeNode tc = TreeNode.getTreeFromArray(child);
        assertFalse(test.isContains(tp,tc));
    }

    @Test
    void isContains3() {
        int[] parent = {1,0,Integer.MIN_VALUE,-4,-3};
        int[] child = {1,-4};
        TreeNode tp = TreeNode.getTreeFromArray(parent);
        TreeNode tc = TreeNode.getTreeFromArray(child);
        assertFalse(test.isContains(tp,tc));
    }
}