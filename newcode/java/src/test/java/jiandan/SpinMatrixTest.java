package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpinMatrixTest {
    private static SpinMatrix test;

    @BeforeAll
    public static void init(){
        test = new SpinMatrix();
    }
    @Test
    void spiralOrder1() {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Integer[] res = new Integer[]{1,2,3,6,9,8,7,4,5};
        ArrayList<Integer> exp = new ArrayList();
        Collections.addAll(exp, res);
        assertEquals(exp, test.spiralOrder(matrix));
    }

    @Test
    void spiralOrder2() {
        int[][] matrix = {};
        Integer[] res = new Integer[]{};
        ArrayList<Integer> exp = new ArrayList();
        Collections.addAll(exp, res);
        assertEquals(exp, test.spiralOrder(matrix));
    }

    @Test
    void spiralOrder3() {
    }
}