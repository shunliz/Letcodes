package letcode.zhongdeng;

import newcode.zhongdeng.TreeTraverse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermuteSolutionTest {

    private static PermuteSolution test;

    @BeforeAll
    public static void init(){
        test = new PermuteSolution();
    }

    @Test
    void permute() {
        int[] arr = {1,2,3};
        List<List<Integer>> res= test.permute(arr);
        List<List<Integer>> exp = new ArrayList<>();
        assertEquals(6, res.size());

    }
}