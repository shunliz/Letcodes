package newcode.jiandan;

import newcode.jiandan.Sqrt;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    private static Sqrt test;

    @BeforeAll
    public static void init(){
        test = new Sqrt();
    }

    @Test
    void sqrt() {
        assertEquals(46294, test.sqrt(2143195649));
    }

    @Test
    void sqrt2() {
        assertEquals(1, test.sqrt(2));
    }
}