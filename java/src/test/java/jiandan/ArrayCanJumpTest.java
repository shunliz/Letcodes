package jiandan;

import newcode.jiandan.ArrayCanJump;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCanJumpTest {

    private static ArrayCanJump test;

    @BeforeAll
    public static void init(){
        test = new ArrayCanJump();
    }

    @Test
    void canJump() {
        int[] arr = {2,1,3,3,0,0,100};
        assertTrue(test.canJump(arr));
    }

    @Test
    void canJump2() {
        int[] arr = {2,1,3,2,0,0,100};
        assertFalse(test.canJump(arr));
    }
}