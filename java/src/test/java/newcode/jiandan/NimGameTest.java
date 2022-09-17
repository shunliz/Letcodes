package newcode.jiandan;

import newcode.jiandan.NimGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NimGameTest {
    private static NimGame test;

    @BeforeAll
    public static void init(){
        test = new NimGame();
    }
    @Test
    void nimGame() {
        assertFalse(test.NimGame(4));
    }

    @Test
    void nimGame2() {
        assertTrue(test.NimGame(2));
    }
}