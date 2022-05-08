package jiandan;

import newcode.jiandan.ArrayMoveZeros;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMoveZerosTest {

    private static ArrayMoveZeros test;

    @BeforeAll
    public static void init(){
        test = new ArrayMoveZeros();
    }

    @Test
    void moveZeroes() {
        int[] arr = {1,2,0,3};
        int[] exp = {1,2,3,0};
        assertArrayEquals(exp, test.moveZeroes(arr));
    }

    @Test
    void moveZeroes2() {
        int[] arr = {1,2,3};
        int[] exp = {1,2,3};
        assertArrayEquals(exp, test.moveZeroes(arr));
    }

    @Test
    void moveZeroes3() {
        int[] arr = {0,0};
        int[] exp = {0,0};
        assertArrayEquals(exp, test.moveZeroes(arr));
    }
}