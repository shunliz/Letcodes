package newcode.jiandan;

import newcode.jiandan.SpinArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpinArrayTest {

    private static SpinArray test;

    @BeforeAll
    public static void init(){
        test = new SpinArray();
    }

    @Test
    void search() {
        int[] arr = {6,8,10,0,2,4};
        assertEquals(2, test.search(arr,10));
    }

    @Test
    void search2() {
        int[] arr = {6,8,10,0,2,4};
        assertEquals(-1, test.search(arr,3));
    }

    @Test
    void search3() {
        int[] arr = {2};
        assertEquals(-1, test.search(arr,1));
    }
}