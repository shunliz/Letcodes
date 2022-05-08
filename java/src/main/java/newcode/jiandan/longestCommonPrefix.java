package newcode.jiandan;

/**
 * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
 *
 * 数据范围： 0≤len(strsi)≤5000
 * 进阶：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 * https://www.nowcoder.com/practice/28eb3175488f4434a4a6207f6f484f47?tpId=117&tqId=37752&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */


public class longestCommonPrefix {
    public String longestCommonPrefix (String[] strs) {
        // write code here
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int len = 0;
        boolean flag = true;
        while(flag){
            int i = 0;
            for(;i< strs.length;i++){
                if(strs[i].length() == 0){
                    return "";
                }
                if(len>=strs[i].length()||strs[i].charAt(len) != strs[0].charAt(len)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                len ++;
            }else{
                break;
            }
        }

        return len ==0?"":strs[0].substring(0,len);
    }
}
