package newcode.jiandan;

import newcode.jiandan.StringTrans;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringTransTest {

    private static StringTrans test;

    @BeforeAll
    public static void init(){
        test = new StringTrans();
    }

    @Test
    void trans() {
        assertEquals("SAMPLE A IS tHIS", test.trans("This is a sample",16));
    }

    @Test
    void trans2() {
        assertEquals("NOWCODER", test.trans("nowcoder",8));
    }

    @Test
    void trans3() {
        assertEquals("Ios", test.trans("iOS",3));
    }
}