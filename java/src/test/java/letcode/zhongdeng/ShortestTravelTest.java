package letcode.zhongdeng;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortestTravelTest {

    private static ShortestTravel test;

    @BeforeAll
    public static void init(){
        test = new ShortestTravel();
    }

    @Test
    void solution() {
        int[] A = {2,1,1,3,2,1,1,3};
        assertEquals(3, test.solution(A));
    }


    @Test
    void solution2() {
        String[] n = {"test1","name2a","name2b","haha3a","haha3b","haha3c","jack4a","jack4b"};
        String[] r = {"passed","failed","passed","passed","passed","passed","timeout","failed"};
        assertEquals(50, test.solution2(n, r));
    }

    @Test
    void solution3() {
        String[] sample = {"5","2","C","D","+"};
        assertEquals(30, test.solution3(sample));
    }
}