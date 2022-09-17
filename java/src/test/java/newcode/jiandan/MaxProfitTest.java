package newcode.jiandan;

import newcode.jiandan.MaxProfit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    private static MaxProfit test;

    @BeforeAll
    public static void init(){
        test = new MaxProfit();
    }

    @Test
    void maxProfit() {
        int[] arr = {8,9,2,5,4,7,1};
        assertEquals(5,test.maxProfit(arr));
    }

    @Test
    void maxProfit2() {
        int[] arr = {2,4,1};
        assertEquals(2,test.maxProfit(arr));
    }

    @Test
    void maxProfit3() {
        int[] arr = {3,2,1};
        assertEquals(0,test.maxProfit(arr));
    }
}