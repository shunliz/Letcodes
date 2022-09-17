package newcode.jiandan;

import newcode.jiandan.FoundOnceNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoundOnceNumberTest {
    private static FoundOnceNumber test;

    @BeforeAll
    public static void init(){
        test = new FoundOnceNumber();
    }

    @Test
    void foundOnceNumber() {
        int[] arr = {5,4,1,1,5,1,5};
        assertEquals(4,test.foundOnceNumber(arr,3));
    }

    @Test
    void foundOnceNumber2() {
        int[] arr = {2,2,1};
        assertEquals(1,test.foundOnceNumber(arr,2));
    }
}