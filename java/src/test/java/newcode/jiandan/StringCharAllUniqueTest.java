package newcode.jiandan;

import newcode.jiandan.StringCharAllUnique;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCharAllUniqueTest {
    private static StringCharAllUnique test;

    @BeforeAll
    public static void init(){
        test = new StringCharAllUnique();
    }
    @Test
    void isUnique() {
        String string = "nowcoder";
        assertFalse(test.isUnique(string));
    }

    @Test
    void isUnique2() {
        String string = "nowcOder";
        assertTrue(test.isUnique(string));
    }
}