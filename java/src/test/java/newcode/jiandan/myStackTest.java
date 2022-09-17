package newcode.jiandan;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
 *
 * 此栈包含的方法有：
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 *
 * 数据范围：操作数量满足 0≤n≤300  ，输入的元素满足 val≤10000
 * 进阶：栈的各个操作的时间复杂度是 O(1)\O(1)  ，空间复杂度是 O(n)\O(n)
 *
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=117&tags=&title=&difficulty=2&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 *
 */


import newcode.jiandan.myStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class myStackTest {

    private static myStack test;

    @BeforeAll
    public static void init(){
        test = new myStack();
    }

    @Test
    void test() {
        String[] inputs = {"PSH-1","PSH2","MIN","TOP","POP","PSH1","TOP","MIN"};
        LinkedList<Integer> res = new LinkedList<Integer>();
        for(String s: inputs){
            switch (s){
                case "MIN":
                    res.add(test.min());
                    break;
                case "TOP":
                    res.add(test.top());
                    break;
                case "POP":
                    test.pop();
                    break;
                default:
                    String opts = s.substring(3,s.length());
                    Integer opt = Integer.valueOf(opts);
                    test.push(opt);
            }
        }
        Integer[] exp = new Integer[]{-1,2,1,-1};
        assertArrayEquals(exp,res.toArray(new Integer[]{}));
    }

}