package jiandan;

import newcode.jiandan.PuKePaiShunZi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuKePaiShunZiTest {

    private static PuKePaiShunZi test;

    @BeforeAll
    public static void init(){
        test = new PuKePaiShunZi();
    }

    @Test
    void isContinuous() {
        int[] arr = {6,0,2,0,4};
        assertTrue(test.IsContinuous(arr));
    }

    @Test
    void isContinuous2() {
        int[] arr = {1,0,0,1,0};
        assertFalse(test.IsContinuous(arr));
    }

    @Test
    void isContinuous3() {
        int[] arr = {0,3,2,6,4};
        assertTrue(test.IsContinuous(arr));
    }

    @Test
    void isContinuous4() {
        int[] arr = {13,12,11,0,1};
        assertFalse(test.IsContinuous(arr));
    }
}