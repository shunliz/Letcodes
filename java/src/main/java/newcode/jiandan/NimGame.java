package newcode.jiandan;

/**
 * 描述
 * 这是一个经典的博弈。
 * 你和你的朋友，两个人玩一个游戏。
 * 1.桌子上有 n 个石头
 * 2.你和你的朋友轮流取石头，你先手。
 * 3.每一回合可以取 1~3 个石头。
 * 4.轮到你的朋友时桌上没有石头则你获胜，否则你的朋友获胜。
 *
 * 你和你的朋友都尽力让自己获胜，如果你有方法必胜，则返回 true ，如果你的朋友有方法必胜，则返回 false
 *
 * 数据范围： 1≤n≤10^9
 *
 *https://www.nowcoder.com/practice/bb574ea90ed2495680fef88d59238231?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */


public class NimGame {
    public boolean NimGame (int n) {
        // write code here
        if ( n % 4 == 0) {//若是4的倍数，则朋友必胜
            return false;
        }else {//非4的倍数
            return true;
        }
    }
}
