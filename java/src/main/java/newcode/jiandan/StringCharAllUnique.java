package newcode.jiandan;

/**
 * 描述
 * 给定一个字符串，请你判断其中每个字符是否全都不同。
 *
 * 数据范围：字符串长度满足 1≤n≤100
 * https://www.nowcoder.com/practice/fb08c63e2c4f4f7dbf41086e46044211?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class StringCharAllUnique {
    public boolean isUnique (String str) {
        // write code here
        int[] flags = new int[256];
        for(int i=0;i<str.length();i++){
            flags[str.charAt(i)]++;
        }
        for(int i=0;i<256;i++){
            if(flags[i]>1){
                return false;
            }
        }
        return true;
    }
}
