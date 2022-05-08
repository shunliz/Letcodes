package jiandan;

import newcode.jiandan.NumberOfRepeatK;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfRepeatKTest {
    private static NumberOfRepeatK test;

    @BeforeAll
    public static void init(){
        test = new NumberOfRepeatK();
    }

    @Test
    void getNumberOfK() {
        int[] arr = {1,2,3,3,3,3,4,5};
        assertEquals(4,test.GetNumberOfK(arr,3));
    }

    @Test
    void getNumberOfK2() {
        int[] arr = {1,3,4,5};
        assertEquals(0,test.GetNumberOfK(arr,6));
    }

    @Test
    void getNumberOfK3() {
        int[] arr = {3};
        assertEquals(1,test.GetNumberOfK(arr,3));
    }
}