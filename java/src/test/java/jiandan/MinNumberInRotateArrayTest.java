package jiandan;

import newcode.jiandan.MinNumberInRotateArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinNumberInRotateArrayTest {
    private static MinNumberInRotateArray test;

    @BeforeAll
    public static void init(){
        test = new MinNumberInRotateArray();
    }


    @Test
    void minNumberInRotateArray() {
        int[] arr = {3,4,5,1,2};
        assertEquals(1,test.minNumberInRotateArray(arr));
    }

    @Test
    void minNumberInRotateArray2() {
        int[] arr = {3,100,200,3};
        assertEquals(3,test.minNumberInRotateArray(arr));
    }
}