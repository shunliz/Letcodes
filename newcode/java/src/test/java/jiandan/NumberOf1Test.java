package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf1Test {
    private static NumberOf1 test;

    @BeforeAll
    public static void init(){
        test = new NumberOf1();
    }


    @Test
    void numberOf1() {
        assertEquals(2,test.NumberOf1(10));
    }

    @Test
    void numberOf2() {
        assertEquals(32,test.NumberOf1(-1));
    }


}