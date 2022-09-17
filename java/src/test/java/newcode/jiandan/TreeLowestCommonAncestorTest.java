package newcode.jiandan;

import newcode.jiandan.TreeLowestCommonAncestor;
import newcode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeLowestCommonAncestorTest {
    private static TreeLowestCommonAncestor test;

    @BeforeAll
    public static void init(){
        test = new TreeLowestCommonAncestor();
    }
    @Test
    void lowestCommonAncestor() {
        int[] arr = {7,1,12,0,4,11,14,Integer.MIN_VALUE,Integer.MIN_VALUE,3,5};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        assertEquals(7,test.lowestCommonAncestor(root,1,12));
    }

    @Test
    void lowestCommonAncestor2() {
        int[] arr = {7,1,12,0,4,11,14,Integer.MIN_VALUE,Integer.MIN_VALUE,3,5};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        assertEquals(12,test.lowestCommonAncestor(root,12,11));
    }
}