package newcode.jiandan;

/**
 *描述
 * 输入一个整数 n ，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 *
 * 数据范围：- 2^{31} <= n <= 2^{31}-1
 * 即范围为:−2147483648<=n<=2147483647
 *
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class NumberOf1 {

    public int NumberOf1(int n) {
        int x = n;

        int count = 0;
        while(x !=0){
            x = x & (x-1);
            count++;
        }
        return count;

    }

    public int NumberOf12(int n) {
        int res = 0;
        //遍历32位
        for(int i = 0; i < 32; i++){
            //按位比较
            if((n & (1 << i)) != 0)
                res++;
        }
        return res;

    }
}
