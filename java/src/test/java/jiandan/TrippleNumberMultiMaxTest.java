package jiandan;

import newcode.jiandan.TrippleNumberMultiMax;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrippleNumberMultiMaxTest {
    private static TrippleNumberMultiMax test;

    @BeforeAll
    public static void init(){
        test = new TrippleNumberMultiMax();
    }


    @Test
    void solve() {
        int[] arr = {3,4,1,2};
        assertEquals(24,test.solve(arr));
    }

    @Test
    void solve2() {
        int[] arr = {10000,10000,100,10000};
        assertEquals(1000000000000L,test.solve(arr));
    }
}