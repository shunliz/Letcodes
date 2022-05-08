package newcode.jiandan;
/**
 * 描述
 * 在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 *
 *
 * 数据范围：0≤n≤10000，且字符串只有字母组成。
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=117&tqId=37762&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] flags = new int[52];
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int indx =Character.isUpperCase(c)?c-'A'+26:c-'a';
            flags[indx]++;
        }
        Character firstc = null ;
        for(int j=0;j<str.length();j++){
            char c = str.charAt(j);
            int indx =Character.isUpperCase(c)?c-'A'+26:c-'a';
            if(flags[indx] == 1){
                firstc = c;
                break;
            }
        }
        if(firstc !=null){
            return str.indexOf(firstc);
        }
        return -1;
    }
}
