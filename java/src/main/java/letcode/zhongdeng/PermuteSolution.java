package letcode.zhongdeng;

import java.util.ArrayList;
import java.util.List;

public class PermuteSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
//终止条件，如果数字都被使用完了，说明找到了一个排列，（可以把它看做是n叉树到
//叶子节点了，不能往下走了，所以要返回）
        if (tempList.size() == nums.length) {
//因为list是引用传递，这里必须要重新new一个
            list.add(new ArrayList<>(tempList));
            return;
        }
//（可以把它看做是遍历n叉树每个节点的子节点）
        for (int i = 0; i < nums.length; i++) {
//因为不能有重复的，所以有重复的就跳过
            if (tempList.contains(nums[i])) {
                continue;
            }
//选择当前值
            tempList.add(nums[i]);
//递归（可以把它看做遍历子节点的子节点）
            backtrack(list, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}
