package newcode.jiandan;

import newcode.jiandan.MaxDiffInArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDiffInArrayTest {
    private static MaxDiffInArray test;

    @BeforeAll
    public static void init(){
        test = new MaxDiffInArray();
    }

    @Test
    void getDis() {
        int[] arr = {5,1};
        assertEquals(0, test.getDis(arr,2));
    }

    @Test
    void getDis2() {
        int[] arr = {5,6};
        assertEquals(1, test.getDis(arr,2));
    }
}