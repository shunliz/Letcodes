package newcode.jiandan;

import newcode.jiandan.FindGreatestSumOfSubArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class FindGreatestSumOfSubArrayTest {

    private static FindGreatestSumOfSubArray test;

    @BeforeAll
    public static void init(){
        test = new FindGreatestSumOfSubArray();
    }

    @org.junit.jupiter.api.Test
    void test1() {
        int[] arr = new int[]{1,-2,3,10,-4,7,2,-5};
        int ret = test.FindGreatestSumOfSubArray(arr);
        Assertions.assertEquals(18,ret);
    }

    @org.junit.jupiter.api.Test
    void test2() {
        int[] arr = new int[]{2};
        int ret = test.FindGreatestSumOfSubArray(arr);
        Assertions.assertEquals(2,ret);
    }

    @org.junit.jupiter.api.Test
    void test3() {
        int[] arr = new int[]{-10};
        int ret = test.FindGreatestSumOfSubArray(arr);
        Assertions.assertEquals(-10,ret);
    }
}