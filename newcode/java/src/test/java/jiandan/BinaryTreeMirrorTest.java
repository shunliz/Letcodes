package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeMirrorTest {

    private static BinaryTreeMirror test;

    @BeforeAll
    public static void init(){
        test = new BinaryTreeMirror();
    }

    @Test
    void mirror() {
        int[] arr = {8,6,10,5,7,9,11};
        int[] exp = {8,10,6,11,9,7,5};
        TreeNode tree = test.getTreeFromArray(arr);
        assertArrayEquals(exp,test.getArrayFromTree(test.Mirror(tree)));
    }

    @Test
    void mirror12() {
        int[] arr = {8,6,10,5,7,9,11};
        int[] exp = {8,10,6,11,9,7,5};
        TreeNode tree = test.getTreeFromArray(arr);
        assertArrayEquals(exp,test.getArrayFromTree(test.Mirror2(tree)));
    }

    @Test
    void mirror13() {
        int[] arr = {8,6,10,5,7,9,11};
        int[] exp = {8,10,6,11,9,7,5};
        TreeNode tree = test.getTreeFromArray(arr);
        assertArrayEquals(exp,test.getArrayFromTree(test.Mirror3(tree)));
    }

    @Test
    void mirror2() {
        int[] arr = {};
        int[] exp = {};
        TreeNode tree = test.getTreeFromArray(arr);
        assertArrayEquals(exp,test.getArrayFromTree(test.Mirror(tree)));
    }
}