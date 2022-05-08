package newcode.jiandan;

/**
 * 描述
 * 给定一个非负整数 num ，生成杨辉三角的前 num 行。
 * 杨辉三角中，每个数是左上方和右上方的数之和。
 *
 * 数据范围： 1≤num≤30
 *https://www.nowcoder.com/practice/4385fa1c390e49f69fcf77ecffee7164?tpId=117&tqId=39590&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */


public class YanghuiSanJioaXing {
    public int[][] generate (int num) {
        // write code here
        int[][] arr = new int[num][];
        int i,j;

        for(i=0;i<num;i++){
            arr[i] = new int[i+1];
            if(i==0)arr[0][0]=1;
            else {
                for(j=0;j<=i;j++){
                    int t1 = j-1<0?0:arr[i-1][j-1];
                    int t2 = j == i?0:arr[i-1][j];
                    arr[i][j]=t2+t1;
                }
            }
        }
        return arr;
    }

}
