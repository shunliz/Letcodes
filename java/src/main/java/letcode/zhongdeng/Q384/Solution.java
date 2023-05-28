package letcode.zhongdeng.Q384;


import java.util.Arrays;
import java.util.Random;

class Solution {
    private int[] nums;
    private Random rand = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for(int i=0;i<n;i++){
            int k = i + rand.nextInt(n-i);
            swap(copy, i, k);
        }
        return copy;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}