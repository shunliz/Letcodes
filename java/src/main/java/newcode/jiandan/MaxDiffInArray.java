package newcode.jiandan;

/**
 * 描述
 * 有一个长为 n 的数组 A ，求满足 0 ≤ a ≤ b < n 的 A[b] - A[a] 的最大值。
 * 给定数组 A 及它的大小 n ，请返回最大差值。
 *
 *数据范围： 2<n≤2∗10^5
 *数组中的值满足 0≤∣val∣≤5∗10^8
 *https://www.nowcoder.com/practice/a01abbdc52ba4d5f8777fb5dae91b204?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */

public class MaxDiffInArray {
    public int getDis (int[] A, int n) {
        // write code here
        int max = 0;
        int min = A[0];
        for(int i=0;i<n;i++){
            min = Math.min(A[i],min);
            max = Math.max(A[i]-min, max);
        }
        return max;
    }
}
