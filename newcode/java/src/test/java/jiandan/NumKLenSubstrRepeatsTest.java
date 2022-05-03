package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumKLenSubstrRepeatsTest {
    private static NumKLenSubstrRepeats test;

    @BeforeAll
    public static void init(){
        test = new NumKLenSubstrRepeats();
    }

    @Test
    void numKLenSubstrRepeats() {
        assertEquals(4,test.numKLenSubstrRepeats("createfunonyoka",4));
    }

    @Test
    void numKLenSubstrRepeats2() {
        assertEquals(1,test.numKLenSubstrRepeats("yokagames",3));
    }

    @Test
    void numKLenSubstrRepeats3() {
        assertEquals(0,test.numKLenSubstrRepeats("yoka",4));
    }

    @Test
    void numKLenSubstrRepeats4() {
        assertEquals(4,test.numKLenSubstrRepeats("ababab",3));
    }
}