package zhongdeng;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.server.ExportException;

import static org.junit.jupiter.api.Assertions.*;

class GetLeastKNumbersTest {

    private static GetLeastKNumbers test;

    @BeforeAll
    public static void init(){
        test = new GetLeastKNumbers();
    }

    @Test
    void getLeastNumbers_Solution() {
        int[] arr = {4,5,1,6,3,7,3,8};
        int[] exp = {1,2,3,4};
        //int[] res = test.GetLeastNumbers_Solution(arr,4).toArray();
        //assertArrayEquals(exp, res);
    }

    @Test
    void getLeastNumbers_Solution2() {
        int[] arr = {1};
        int[] exp = {};
        //int[] res = test.GetLeastNumbers_Solution(arr,0).toArray();
        //assertArrayEquals(exp, res);
    }
}