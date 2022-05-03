package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxLexicographicalTest {
    private static MaxLexicographical test;

    @BeforeAll
    public static void init(){
        test = new MaxLexicographical();
    }

    @Test
    void maxLexicographical() {
        assertEquals("1111",test.maxLexicographical("1000"));
    }

    @Test
    void maxLexicographical2() {
        assertEquals("1111",test.maxLexicographical("1001"));
    }
}