package newcode.zhongdeng;

import newcode.ListNode;

import java.util.Random;

public class ListGetRandom {
    /**
     * 给你一个未知长度的单链表，请你设计一个算法，只能遍历一次，随机地返回链表中的一个节点
     *
     *这个问题的难点在于随机选择是「动态」的，比如说你现在你已经遍历了 5 个元素，
     * 你已经随机选取了其中的某个元素a作为结果，但是现在再给你一个新元素b，
     * 你应该留着a还是将b作为结果呢？以什么逻辑做出的选择，
     * 才能保证你的选择方法在概率上是公平的呢？
     *
     *先说结论，当你遇到第i个元素时，应该有1/i的概率选择该元素，1 - 1/i的概率保持原有的选择
     *
     *
     * 1/i * (1-1/(i+1)) * (1-1/(i+2)).....(1-1/n) = 1/n
     * 第i个元素被选择的概率是1/i，在第i+1次不被替换的概率是1 - 1/(i+1)，
     * 在第i+2次不被替换的概率是1 - 1/(i+2)，
     * 以此类推，相乘的结果是第i个元素最终被选中的概率，也就是1/n。
     * 因此，该算法的逻辑是正确的。
     */
    int getRandom(ListNode head) {
        Random r = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (0 == r.nextInt(i)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }


    /**
     * 返回链表中 k 个随机节点的值
     *
     * 如果要在单链表中随机选择k个数，只要在第i个元素处以k/i的概率选择该元素，
     * 以1 - k/i的概率保持原有选择即可
     *
     *
     *k/i * (1-k/(i+1) * 1/k) * (1-k/(i+2) * 1/k).....(1-k/n * 1/k) = k/n
     * */
    int[] getRandomk(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;

        // 前 k 个元素先默认选上
        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }

        int i = k;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }


    // 在区间 [lo, hi) 中随机抽取 k 个数字
    int[] sample(int lo, int hi, int k) {
        Random r = new Random();
        int[] res = new int[k];

        // 前 k 个元素先默认选上
        for (int i = 0; i < k; i++) {
            res[i] = lo + i;
        }

        int i = k;
        // while 循环遍历数字区间
        while (i < hi - lo) {
            i++;
            // 生成一个 [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = lo + i - 1;
            }
        }
        return res;
    }


}
