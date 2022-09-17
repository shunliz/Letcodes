package newcode.jiandan;

import newcode.jiandan.IsPalindromeNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeNumberTest {

    private static IsPalindromeNumber test;

    @BeforeAll
    public static void init(){
        test = new IsPalindromeNumber();
    }


    @Test
    void isPalindrome() {
        assertTrue(test.isPalindrome(121));
    }

    @Test
    void isPalindrome2() {
        assertFalse(test.isPalindrome(122));
    }
}