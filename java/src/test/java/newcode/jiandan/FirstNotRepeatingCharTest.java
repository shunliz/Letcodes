package newcode.jiandan;

import newcode.jiandan.FirstNotRepeatingChar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNotRepeatingCharTest {
    private static FirstNotRepeatingChar test;

    @BeforeAll
    public static void init(){
        test = new FirstNotRepeatingChar();
    }
    @Test
    void firstNotRepeatingChar() {
        String s = "google";
        assertEquals(4, test.FirstNotRepeatingChar(s));
    }

    @Test
    void firstNotRepeatingChar2() {
        String s = "aa";
        assertEquals(-1, test.FirstNotRepeatingChar(s));
    }
}