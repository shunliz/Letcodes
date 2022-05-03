package jiandan;

/**
 * 给定一个长度为 n 的整型数组 arr 和一个整数 k(k>1) 。
 * 已知 arr 中只有 1 个数出现一次，其他的数都出现 k 次。
 * 请返回只出现了 1 次的数。
 *
 * 数据范围: 1≤n≤2∗10^5
 * 1<k<100 ， −2∗10^9≤arr[i]≤2∗10^9
 *
 * 进阶：时间复杂度 O(32n)O(32n)，空间复杂度 O(1)O(1)
 *https://www.nowcoder.com/practice/5d3d74c3bf7f4e368e03096bb8857871?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class FoundOnceNumber {

    public int foundOnceNumber (int[] arr, int k) {
        // write code here
        int[] bits = new int[32];
        for(int i = 0;i<arr.length;i++){
            for(int j=0;j<32;j++){
                bits[j] += (arr[i]>>j)&1;
            }
        }

        int res =0;
        for(int j=0;j<32;j++){
            if(bits[j] %k !=0){
                res += (1<<j);
            }
        }
        return res;
    }

}
