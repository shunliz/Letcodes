package jiandan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagQuestionsTest {

    private static BagQuestions test;

    @BeforeAll
    public static void init(){
        test = new BagQuestions();
    }

    @Test
    void oneZeroBags() {
        int[] values = {2,4,4,5};
        int[] weights = {1,2,3,4};
        int capacity = 5;
        assertEquals(8, test.OneZeroBags(weights,values,5,4));
    }

    @Test
    void oneZeroBags2() {
        int[] values = {2,4,4,5};
        int[] weights = {1,2,3,4};
        int capacity = 5;
        assertEquals(8, test.OneZeroBags2(weights,values,5,4));
    }


    @Test
    void fullBangQuestions() {
        int[] values = {2,4,4,5};
        int[] weights = {1,2,3,4};
        int capacity = 5;
        assertEquals(10, test.FullBangQuestions(weights,values,5,4));
    }

    @Test
    void fullBangQuestions2() {
        int[] values = {5,4,3,2};
        int[] weights = {1,2,3,4};
        int capacity = 5;
        assertEquals(25, test.FullBangQuestions(weights,values,5,4));
    }

    @Test
    void multiBagQuestions() {
        int[] values = {5,4,3,2};
        int[] weights = {1,2,3,4};
        int[] nums = {2,2,3,4};
        int capacity = 5;
        assertEquals(14, test.MultiBagQuestions(weights,values,nums,5,4));
    }

    @Test
    void multiBagQuestions22() {
        Integer[] values = {5,4,3,2};
        Integer[] weights = {1,2,3,4};
        Integer[] nums = {2,2,3,4};
        int capacity = 5;
        assertEquals(14, test.MultiBagQuestions2(weights,values,nums,5,4));
    }

    @Test
    void multiBagQuestions2() {
        int[] values = {2,4,4,5};
        int[] weights = {1,2,3,4};
        int[] nums = {3,1,3,2};
        int capacity = 5;
        assertEquals(10, test.MultiBagQuestions(weights,values,nums,5,4));
    }

    @Test
    void hybidBagQuestions() {
        Integer[] values = {2,4,4,5};
        Integer[] weights = {1,2,3,4};
        Integer[] nums = {-1,1,0,2};
        int capacity = 5;
        assertEquals(8, test.hybidBagQuestions(weights,values,nums,5,4));
    }
}