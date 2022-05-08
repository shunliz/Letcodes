package zhongdeng;

import newcode.TreeNode;
import newcode.zhongdeng.TreeTraverse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 描述
 * 给定一棵二叉树，分别按照二叉树先序，中序和后序打印所有的节点。
 *
 * 数据范围：0≤n≤1000，树上每个节点的val值满足 0≤val≤100
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 *https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=117&tqId=37819&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D3%26page%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=3&judgeStatus=undefined&tags=&title=
 */

class TreeTraverseTest {

    private static TreeTraverse test;

    @BeforeAll
    public static void init(){
        test = new TreeTraverse();
    }

    @Test
    void threeOrders() {
        int[] arr = {1,2,3};
        int[][] exp = {{1,2,3},{2,1,3},{2,3,1}};
        TreeNode tree = getTree(arr);
        int[][] res = test.threeOrders(tree);
        assertArrayEquals(exp, res);
    }

    @Test
    void threeOrders2() {
        int[] arr = {};
        int[][] exp = {{},{},{}};
        TreeNode tree = getTree(arr);
        int[][] res = test.threeOrders(tree);
        assertArrayEquals(exp, res);
    }

    private TreeNode getTree(int[] arr) {
        if(arr.length == 0){
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        LinkedList<TreeNode> ts = new LinkedList<TreeNode>();
        Integer val = list.poll();
        TreeNode tree = new TreeNode(val);
        ts.offer(tree);
        while(true){
            if(ts.isEmpty()){
                break;
            }
            TreeNode node = ts.poll();
            TreeNode ln = null;
            TreeNode rn = null;
            if(!list.isEmpty()){
                int lval = list.poll();
                ln = lval == -1?null:new TreeNode(lval);
                if(node != null){
                    node.left = ln;
                }
                ts.offer(ln);
            }else{
                break;
            }
            if(!list.isEmpty()){
                int rval = list.poll();
                rn = rval == -1?null:new TreeNode(rval);
                if(node != null){
                    node.right = rn;
                }
                ts.offer(rn);
            }else{
                break;
            }
        }
        return tree;
    }
}