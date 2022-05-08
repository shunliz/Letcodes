/**
 描述
 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。求所有子数组的和的最大值。
 数据范围:
 1<=n<=2×10^5
 -100 <= a[i] <= 100

 要求:时间复杂度为 O(n)O(n)，空间复杂度为 O(n)O(n)
 进阶:时间复杂度为 O(n)O(n)，空间复杂度为 O(1)O(1)

 https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=117&tqId=37797&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 *
 */

function FindGreatestSumOfSubArray(array)
{
    // write code here
    let sum =0, max = -1001
    for(var indx in array){
        if(sum <0){
            sum = array[indx]
        }else{
            sum = sum + array[indx]
        }
        
        if(sum > max){
            max = sum 
        }
        
    }
    return max
}
module.exports = {
    FindGreatestSumOfSubArray : FindGreatestSumOfSubArray
};