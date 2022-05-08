package newcode.jiandan;

/**
 * 描述
 * 给定一个数组，请你实现将所有 0 移动到数组末尾并且不改变其他数字的相对顺序。
 *
 * 数据范围：数组长度满足 1 \le n \le 1000 \1≤n≤1000 ，数组中的元素满足 1≤val≤1000
 *https://www.nowcoder.com/practice/102586387caa4afcbad6f96affce9780?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class ArrayMoveZeros {
    public int[] moveZeroes (int[] nums) {
        // write code here
        for(int i=0;i<nums.length;){
            if(nums[i] == 0){
                boolean flag = false;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j] !=0){
                        flag = true;
                    }
                    nums[j-1] = nums[j];
                }
                nums[nums.length-1] = 0;
                if(!flag){
                    break;
                }
            }else{
                i++;
            }
        }
        return nums;
    }
}
