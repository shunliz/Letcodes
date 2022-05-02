package jiandan;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述
 * 现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子。
 * 有如下规则：
 * 1. A为1，J为11，Q为12，K为13，A不能视为14
 * 2. 大、小王为 0，0可以看作任意牌
 * 3. 如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false。
 * 4.数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
 *
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(nlogn)O(nlogn)，本题也有时间复杂度 O(n)O(n) 的解法
 * 输入描述：
 * 输入五张扑克牌的值
 * 返回值描述：
 * 五张扑克牌能否组成顺子。
 * https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class PuKePaiShunZi {

    public boolean IsContinuous(int [] numbers) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min =Integer.MAX_VALUE;
        //遍历数组
        for (int number:
                numbers) {
            if(number == 0) {
                continue;
            }
            //包含相同牌则直接返回，否则加入
            if(set.contains(number)){
                return false;
            }else {
                set.add(number);
            }
            //每次遍历记录最大值，最小值
            max = StrictMath.max(max,number);
            min = StrictMath.min(min,number);
        }
        return max - min < 5;
    }
}
