package jiandan;


/**
 * 描述
 * 给定一个非负整数数组nums，假定最开始处于下标为0的位置，数组里面的每个元素代表下一跳能够跳跃的最大长度。如果能够跳到数组最后一个位置，则返回true，否则返回false。
 * https://www.nowcoder.com/practice/23407eccb76447038d7c0f568370c1bd?tpId=117&tqId=39372&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */
public class ArrayCanJump {

    public boolean canJump (int[] nums) {
        // write code here
        int reach = 0; // 目前最远能跳到的点
        for (int i = 0; i < nums.length; i++) {
            // 之前的点都跳不到当前的点，所以失败
            if (reach < i) return false;
            // 已经能跳到最后一个点了，直接返回
            if (reach >= nums.length-1) return true;
            // 如果通过当前的点能够到更远的点，更新reach
            reach = Math.max(reach, i + nums[i]);
        }

        return true;
    }

}
