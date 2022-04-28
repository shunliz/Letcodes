package jiandan;

/**
 * 实现函数 int sqrt(int x).
 * 计算并返回 x 的平方根（向下取整）
 *
 * 数据范围： 0 <= x < 2^{31}-1
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(logx)O(logx)
 *
 *
 *https://www.nowcoder.com/practice/09fbfb16140b40499951f55113f2166c?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */

public class Sqrt {

    public int sqrt (int x) {
        // write code here
        for(int i=1;i<=x/2+1;i++){
            if(i*i >=x){
                return i-1;
            }else if(i*i ==x){
                return i;
            }
        }
        return -1;
    }
}
