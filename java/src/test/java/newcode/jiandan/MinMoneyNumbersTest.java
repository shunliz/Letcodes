package newcode.jiandan;

import newcode.jiandan.MinMoneyNumbers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MinMoneyNumbersTest {

    private static MinMoneyNumbers test;

    @BeforeAll
    public static void init(){
        test = new MinMoneyNumbers();
    }

    @Test
    void minMoney() {
        int[] arr = {5,2,3};
        assertEquals(4,test.minMoney(arr,20));
    }

    @Test
    void minMoney2() {
        int[] arr = {5,2,3};
        assertEquals(0,test.minMoney(arr,0));
    }

    @Test
    void minMoney3() {
        int[] arr = {5,3};
        assertEquals(-1,test.minMoney(arr,2));
    }

    @Test
    void minMoney4() {
        int[] arr = {5,2,1};
        assertEquals(3,test.minMoney(arr,8));
    }

    @Test
    void minMoney5() {
        int[] arr = {};
        assertEquals(-1,test.minMoney(arr,20));
    }

    @Test
    void minMoney6() {
        int[] arr = {357,322,318,181,22,158,365};
        assertEquals(14,test.minMoney(arr,4976));
    }

}