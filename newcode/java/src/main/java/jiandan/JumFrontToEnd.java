package jiandan;

/**
 * 描述
 * 给你一个长度为 n 的数组 a。
 * ai 表示从 i 这个位置开始最多能往后跳多少格。
 * 求从 1 开始最少需要跳几次就能到达第 n 个格子。
 *https://www.nowcoder.com/practice/de62bcee9f9a4881ac80cce6da42b135?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class JumFrontToEnd {
    public int Jump (int n, int[] A) {
        // write code here
        int[] dp=new int[n+1];
        for(int i=2,j=1;i<=n;i++){
            //贪心地寻找到达第i个格子的前一步所在格子j
            while(j+A[j-1]<i){
                j++;
            }
            //从j位置跳一步到达i位置
            dp[i]=dp[j]+1;
        }
        return dp[n];
    }
}
