package newcode.jiandan;

import newcode.TreeNode;
import newcode.jiandan.TreePostOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreePostOrderTest {

    private static TreePostOrder test;

    @BeforeAll
    public static void init(){
        test = new TreePostOrder();
    }

    @Test
    void postorderTraversal() {
        int[] arr = {1,Integer.MIN_VALUE,2,3};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        int[] exp = {3,2,1};
        assertArrayEquals(exp, test.postorderTraversal(root));
    }

    @Test
    void postorderTraversal2() {
        int[] arr = {1};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        int[] exp = {1};
        assertArrayEquals(exp, test.postorderTraversal(root));
    }

    @Test
    void postorderTraversal3() {
        int[] arr = {3,1,2};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        int[] exp = {1,2,3};
        assertArrayEquals(exp, test.postorderTraversal(root));
    }
}