package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayToBSTTest {
    private static SortedArrayToBST test;

    @BeforeAll
    public static void init(){
        test = new SortedArrayToBST();
    }

    @Test
    void sortedArrayToBST() {
        int[] arr = {-1,0,1,2};
        int[] exp = {1,0,2,-1};
        TreeNode res = test.sortedArrayToBST(arr);
        int[] ares = TreeNode.getArrayFromTree(res);
        assertArrayEquals(exp, ares);
    }

    @Test
    void sortedArrayToBST2() {
        int[] arr = {};
        int[] exp = {};
        TreeNode res = test.sortedArrayToBST(arr);
        int[] ares = TreeNode.getArrayFromTree(res);
        assertArrayEquals(exp, ares);
    }
}