package jiandan;

import newcode.jiandan.DiameterOfBinaryTree;
import newcode.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterOfBinaryTreeTest {
    private static DiameterOfBinaryTree test;

    @BeforeAll
    public static void init(){
        test = new DiameterOfBinaryTree();
    }

    @Test
    void diameterOfBinaryTree() {
        int [] arr = {1,2,3,Integer.MIN_VALUE,Integer.MIN_VALUE,4,5};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        assertEquals(3, test.diameterOfBinaryTree(root));
    }

    @Test
    void diameterOfBinaryTree2() {
        int [] arr = {1,2,3,Integer.MIN_VALUE,Integer.MIN_VALUE,4,5,9,Integer.MIN_VALUE,Integer.MIN_VALUE,6,Integer.MIN_VALUE,7,Integer.MIN_VALUE,8};
        TreeNode root = TreeNode.getTreeFromArray(arr);
        assertEquals(6, test.diameterOfBinaryTree(root));
    }
}