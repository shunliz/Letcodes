package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YanghuiSanJioaXingTest {
    private static YanghuiSanJioaXing test;

    @BeforeAll
    public static void init(){
        test = new YanghuiSanJioaXing();
    }
    @Test
    void generate() {
        int[][] exp = {{1}};
        assertArrayEquals(exp, test.generate(1));
    }

    @Test
    void generate2() {
        int[][] exp = {{1},{1,1},{1,2,1},{1,3,3,1}};
        assertArrayEquals(exp, test.generate(4));
    }
}