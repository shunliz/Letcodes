package jiandan;

import newcode.TreeNode;
import newcode.jiandan.TreePreOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreePreOrderTest {


    private static TreePreOrder test;

    @BeforeAll
    public static void init(){
        test = new TreePreOrder();
    }

    @Test
    void preorderTraversal() {
        int[] arr = {1,Integer.MIN_VALUE,2,3};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        int[] exp = {1,2,3};
        assertArrayEquals(exp, test.preorderTraversal(root));
    }
}