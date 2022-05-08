package newcode.jiandan;

/**
 * 描述
 * 利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2bc5a3。
 * 1.如果只有一个字符，1不用写
 * 2.字符串中只包含大小写英文字母（a至z）。
 *
 * 数据范围:
 * 0<=字符串长度<=50000
 *
 * 要求：时间复杂度O(N）
 * https://www.nowcoder.com/practice/c43a0d72d29941c1b65c857d8ac9047e?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class StringCompress {

    public String compressString (String param) {
        // write code here
        if(param.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        for(;i<param.length()&&j<param.length();){
            if(param.charAt(i) == param.charAt(j)){
                j++;
            }else{
                int cnt = j-i;
                sb.append(param.charAt(i));
                sb.append(cnt>1?cnt : "");
                i=j;
                j++;
            }
        }
        int cnt = j-i;
        sb.append(param.charAt(i));
        sb.append(cnt>1?cnt : "");

        return sb.toString();
    }
}
