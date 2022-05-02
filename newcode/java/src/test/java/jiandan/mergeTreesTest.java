package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

import static org.junit.jupiter.api.Assertions.*;

class mergeTreesTest {

    private static mergeTrees test;

    @BeforeAll
    public static void init(){
        test = new mergeTrees();
    }

    @Test
    void mergeTrees() {
        int[] arr1 = {1,3,2,5};
        int[] arr2 = {2,1,3,Integer.MIN_VALUE,4,Integer.MIN_VALUE,7};
        int[] arr3 = {3,4,5,5,4,Integer.MIN_VALUE,7};
        TreeNode t1 = TreeNode.getTreeFromArray(arr1);
        TreeNode t2 = TreeNode.getTreeFromArray(arr2);
        TreeNode t3 = test.mergeTrees(t1,t2);
        int[] res = TreeNode.getArrayFromTree(t3);
        assertArrayEquals(arr3,res);
    }
}