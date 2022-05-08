package newcode.jiandan;

/**
 * 描述
 * 对于一个长度为 n 字符串，我们需要对它做一些变形。
 *
 * 首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 *
 * 比如"Hello World"变形后就变成了"wORLD hELLO"。
 *
 * 数据范围: 1≤n≤10^6
 *   , 字符串中包括大写英文字母、小写英文字母、空格。
 * 进阶：空间复杂度 O(n)O(n) ， 时间复杂度 O(n)O(n)
 * 输入描述：
 * 给定一个字符串s以及它的长度n(1 ≤ n ≤ 10^6)
 * 返回值描述：
 * 请返回变形后的字符串。题目保证给定的字符串均由大小写字母和空格构成。
 *
 *https://www.nowcoder.com/practice/c3120c1c1bc44ad986259c0cf0f0b80e?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class StringTrans {
    public String trans(String s, int n) {
        // write code here
        if(n==0) {
            return s;
        }
        StringBuffer res=new StringBuffer();
        for(int i = 0; i < n; i++){
            //大小写转换
            if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                res.append((char)(s.charAt(i) - 'A' + 'a'));
            } else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                res.append((char)(s.charAt(i) - 'a' + 'A'));
            } else
                //空格直接复制
            {
                res.append(s.charAt(i));
            }
        }
        //翻转整个字符串
        res = res.reverse();
        for (int i = 0; i < n; i++){
            int j = i;
            //以空格为界，二次翻转
            while(j < n && res.charAt(j) != ' ') {
                j++;
            }
            String temp = res.substring(i,j);
            StringBuffer buffer = new StringBuffer(temp);
            temp = buffer.reverse().toString();
            res.replace(i,j,temp);
            i = j;
        }
        return res.toString();
    }
}
