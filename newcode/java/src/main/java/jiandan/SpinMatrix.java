package jiandan;

/**
 * 描述
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 *
 * 数据范围：0 \le n,m \le 100≤n,m≤10，矩阵中任意元素都满足 |val| \le 100∣val∣≤100
 * 要求：空间复杂度 O(nm)O(nm) ，时间复杂度 O(nm)O(nm)
 *
 * https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31?tpId=117&tqId=37738&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */

import java.util.ArrayList;

public class SpinMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList res = new ArrayList<Integer>();
        if(matrix.length == 0){
            return res;
        }
        int vi =0, vb = matrix[0].length-1;
        int hi = 0, hb = matrix.length-1;

        while(hi < (matrix.length+1)/2 && vi<(matrix[0].length+1)/2){
            for(int i=vi;i<=vb;i++){
                res.add(matrix[hi][i]);
            }
            for(int i=hi+1;i<=hb;i++){
                res.add(matrix[i][vb]);
            }
            for(int i=vb-1;i>= vi&& hi!=hb;i--){
                res.add(matrix[hb][i]);
            }
            for(int i=hb-1;i>= hi+1&& vi!=vb;i--){
                res.add(matrix[i][hi]);
            }
            ++vi;
            --hb;
            ++hi;
            --vb;
        }
        return res;
    }

}
