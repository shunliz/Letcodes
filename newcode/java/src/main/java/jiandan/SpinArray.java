package jiandan;
/**
描述
有一个长度为 n 的按严格升序排列的整数数组 nums ，在实行 search 函数之前，在某个下标 k 上进行旋转，使数组变为[nums[k],nums[k+1],.....,nums[nums.length-1],nums[0],nums[1],.......,nums[k-1]]。
给定旋转后的数组 nums 和一个整型 target ，请你查找 target 是否存在于 nums 数组中并返回其下标（从0开始计数），如果不存在请返回-1。

数据范围： 0 \le n \le 10000 ， 0 \le target \le 1000000≤n≤10000，0≤target≤100000

比如，数组[0,2,4,6,8,10]在下标3处旋转之后变为[6,8,10,0,2,4], 当给定target为10时，10的下标是2，target为3时，nums数组中不存在3，所以返回-1

https://www.nowcoder.com/practice/87c0e7abcbda41e7963660fa7d020995?tpId=117&tqId=37744&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
**/

public class SpinArray {

    public int search (int[] nums, int target) {
        // write code here
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
