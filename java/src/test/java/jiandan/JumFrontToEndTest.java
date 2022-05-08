package jiandan;

import newcode.jiandan.JumFrontToEnd;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumFrontToEndTest {
    private static JumFrontToEnd test;

    @BeforeAll
    public static void init(){
        test = new JumFrontToEnd();
    }
    @Test
    void jump() {
        int[] arr = {1,2};
        assertEquals(1, test.Jump(2, arr));
    }

    @Test
    void jump2() {
        int[] arr = {2,3,1};
        assertEquals(1, test.Jump(3, arr));
    }
}