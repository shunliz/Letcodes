package newcode.jiandan;

import java.util.Arrays;

/**
 * 描述 (背包问题)
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 *
 * 数据范围：数组大小满足 0≤n≤10000 ， 数组中每个数字都满足 0<val≤10000，0≤aim≤5000
 *
 * 要求：时间复杂度 O(n \times aim)O(n×aim) ，空间复杂度 O(aim)O(aim)。
 *
 *https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tpId=117&tqId=37795&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */



public class MinMoneyNumbers {
    public int minMoney (int[] arr, int aim) {
        // write code here
        //dp[i]表示凑齐i元最少需要多少货币数
        int[] dp = new int[aim+1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
        for(int i=1;i<=aim;i++){
            //每种面值的货币都要枚举
            for(int j = 0; j < arr.length; j++){
                //如果面值不超过要凑的钱才能用
                if(arr[j] <= i){
                    //维护最小值
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        //如果最终答案大于aim代表无解
        return dp[aim] > aim ? -1 : dp[aim];
    }
}
