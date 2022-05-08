package newcode.jiandan;

/**
 * 描述
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值。
 *
 * 数据范围：1≤n≤10000，数组中任意元素的值: 0≤val≤10000
 * 要求：空间复杂度：O(1)O(1) ，时间复杂度：O(logn)O(logn)
 *
 *
 *https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length -1;
        while(low < high){
            int mid = (high + low) /2;
            if(array[mid]>array[high]){
                low = mid +1;
            }else if(array[mid] == array[high]){
                high --;
            }else{
                high = mid;
            }
        }
        return array[low];
    }
}
