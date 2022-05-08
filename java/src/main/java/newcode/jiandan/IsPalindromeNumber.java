package newcode.jiandan;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 在不使用额外的内存空间的条件下判断一个整数是否是回文。
 * 回文指逆序和正序完全相同。
 *
 *
 * 数据范围：−2^31≤n≤2^31−1
 * 进阶： 空间复杂度 O(1)O(1)，时间复杂度 O(len(n))O(len(n))
 *
 * 提示：
 * 负整数可以是回文吗？（比如-1）
 * 如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
 * 你可以将整数翻转。但是，如果你做过题目“反转数字”，你会知道将整数翻转可能会出现溢出的情况，你怎么处理这个问题？
 *
 *https://www.nowcoder.com/practice/35b8166c135448c5a5ba2cff8d430c32?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class IsPalindromeNumber {
    public boolean isPalindrome (int x) {
        // write code here
        if(x<0){
            return false;
        }
        List<Integer> ls = new ArrayList<Integer>();
        int temp = x;
        while(temp/10>0){
            ls.add(temp%10);
            temp = temp / 10;
        }
        ls.add(temp%10);
        boolean res = true;
        for(int i=0,j=ls.size()-1;i<j;i++,j--){
            if(!ls.get(i).equals(ls.get(j))){
                res = false;
            }
        }
        return res;
    }
}
