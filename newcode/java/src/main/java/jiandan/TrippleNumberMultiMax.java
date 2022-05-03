package jiandan;
/**
 * 描述
 * 给定一个长度为 nn 的无序数组 AA ，包含正数、负数和 0 ，请从中找出 3 个数，使得乘积最大，返回这个乘积。
 *
 * 要求时间复杂度： O(n)O(n) ，空间复杂度： O(1)O(1) 。
 *
 * 数据范围：3≤n≤10^4
 * −10^4≤A[i]≤10^4
 *
 *https://www.nowcoder.com/practice/8ae05c2913fe438b8b14f3968f64fc0b?tpId=117&tqId=37830&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */

import java.util.Arrays;

public class TrippleNumberMultiMax {
    public long solve (int[] A) {
        // write code here
        Arrays.sort(A);
        long max1 = ((long)A[A.length-1])*A[A.length-2]*A[A.length-3];
        long max2 = ((long)A[0])*A[1]*A[A.length-1];
        return Math.max(max1,max2);
    }
    
}
