package newcode.jiandan;

import newcode.jiandan.longestCommonPrefix;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class longestCommonPrefixTest {
    private static longestCommonPrefix test;

    @BeforeAll
    public static void init(){
        test = new longestCommonPrefix();
    }

    @Test
    void longestCommonPrefix() {
        String[] arr= {"abca","abc","abca","abc","abcc"};
        assertEquals("abc",test.longestCommonPrefix(arr));
    }

    @Test
    void longestCommonPrefix2() {
        String[] arr= {"abc",};
        assertEquals("abc",test.longestCommonPrefix(arr));
    }

    @Test
    void longestCommonPrefix3() {
        String[] arr= {"a","b",};
        assertEquals("",test.longestCommonPrefix(arr));
    }
}