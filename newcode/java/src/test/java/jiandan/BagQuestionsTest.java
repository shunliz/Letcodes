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

    @Test
    void twoDemensionBag() {
        int n = 4;
        int v = 5;
        int m = 6;

        int[] vi = {4,1,2,3,4};
        int[] mi = {5,2,4,4,5};
        int[] wi = {6,3,4,5,6};

        assertEquals(10, test.twoDemensionBag(vi,mi,wi,n,v,m));
    }

    @Test
    void knapsack() {
        int v = 10;
        int n =2;
        int[][] vw = {{1,3},{9,8}};
        assertEquals(11,test.knapsack(v,n,vw));
    }

    @Test
    void knapsack2() {
        int v = 10;
        int n =2;
        int[][] vw = {{1,3},{10,4}};
        assertEquals(4,test.knapsack(v,n,vw));
    }
}