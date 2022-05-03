package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCompressTest {
    private static StringCompress test;

    @BeforeAll
    public static void init(){
        test = new StringCompress();
    }
    @Test
    void compressString() {
        assertEquals("a2bc5a3",test.compressString("aabcccccaaa"));
    }

    @Test
    void compressString2() {
        assertEquals("shope2w",test.compressString("shopeew"));
    }
}