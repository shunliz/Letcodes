package newcode.zhongdeng;

import newcode.zhongdeng.GetLeastKNumbers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GetLeastKNumbersTest {

    private static GetLeastKNumbers test;

    @BeforeAll
    public static void init(){
        test = new GetLeastKNumbers();
    }

    @Test
    void getLeastNumbers_Solution() {
        int[] arr = {4,5,1,6,3,7,2,8};
        Integer[] exp = {1,2,3,4};
        Integer[] res = test.GetLeastNumbers_Solution(arr,4);
        assertEquals(new HashSet<Integer>(Arrays.asList(exp)), new HashSet<Integer>(Arrays.asList(res)));
    }

    @Test
    void getLeastNumbers_Solution2() {
        int[] arr = {1};
        int[] exp = {};
        //int[] res = test.GetLeastNumbers_Solution(arr,0).toArray();
        //assertArrayEquals(exp, res);
    }
}