package jiandan;

public class MaxLexicographical {
    public String maxLexicographical (String num) {
        // write code here
        int l = -1, r = num.length() - 1;
//         第一步把我们的左边界变成-1，右边界变成最后那个单词
        for (int i = 0; i < num.length(); i++) {
//             遍历我们的字符产
            if (num.charAt(i) == '0' && l == -1) l = i;
//             如果找到0，并且左边界未确定，这时候确定左边界
            if (num.charAt(i) == '1' && l != -1) {
//                 找到1，并且左边界确定了，那么更新有边界跳出循环
                r = i;
                break;
            }
        }
        if (l == -1) return num;
//         如果已经是全1的状态，直接返回原来的字符串就可以了
        StringBuffer res = new StringBuffer();
        for (int i = l; i <= r; i++) res.append('1');
//         把这段区间内的1加进来
        return num.substring(0, l) + res.toString() + num.substring(r + 1, num.length());
//         执行一个字符串的拼接操作
    }
}
