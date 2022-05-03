package jiandan;

/**
 * 描述
 * 给你一个由小写字母组成的长度为n的字符串 S ，找出所有长度为 k 且包含重复字符的子串，请你返回全部满足要求的子串的数目。
 *
 * 数据范围： 2≤k≤400 ,5≤n≤900
 * 进阶： 时间复杂度O(n)O(n)，空间复杂度O(n)O(n)
 * https://www.nowcoder.com/practice/eced9a8a4b6c42b79c95ae5625e1d5fd?tpId=117&tqId=39346&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */

public class NumKLenSubstrRepeats {

    public int numKLenSubstrRepeats (String s, int k) {
        // write code here
        int cnt = 0;
        for(int i=0;i<s.length()-k+1;i++){
            String sub = s.substring(i,i+k);
            if(isDup(sub)){
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isDup(String sub) {
        int[] flags = new int[26];
        for(int i=0;i<sub.length();i++){
            flags[sub.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(flags[i]>1){
                return true;
            }
        }
        return false;
    }
}
