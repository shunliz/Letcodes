package jiandan;

import newcode.jiandan.YouXiaoKuoHaoXuLie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YouXiaoKuoHaoXuLieTest {

    private static YouXiaoKuoHaoXuLie test;

    @BeforeAll
    public static void init(){
        test = new YouXiaoKuoHaoXuLie();
    }

    @Test
    void isValid1() {
        String s = "()[]{}";
        assertEquals(true, test.isValid(s));
    }

    @Test
    void isValid2() {
        String s = "[]";
        assertEquals(true, test.isValid(s));
    }

    @Test
    void isValid3() {
        String s = "([)]";
        assertEquals(false, test.isValid(s));
    }

    @Test
    void isValid4() {
    }
}