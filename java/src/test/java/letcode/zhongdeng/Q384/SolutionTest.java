package letcode.zhongdeng.Q384;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void shuffle() {
        int[] nums = {1,2,3,4};
        Solution solution = new Solution(nums);
        int[] res = solution.shuffle();
        for(int i : res){
            System.out.print(i+",");
        }
        System.out.println("");

        int[] reset = solution.reset();
        assertArrayEquals(nums, reset);
    }
}