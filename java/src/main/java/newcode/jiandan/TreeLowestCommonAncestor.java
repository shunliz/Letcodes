package newcode.jiandan;

import newcode.TreeNode;

/**
 *描述
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 1.对于该题的最近的公共祖先定义:对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大。在这里，一个节点也可以是它自己的祖先.
 * 2.二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 3.所有节点的值都是唯一的。
 * 4.p、q 为不同节点且均存在于给定的二叉搜索树中。
 * 数据范围:
 * 3<=节点总数<=10000
 * 0<=节点值<=10000
 *  https://www.nowcoder.com/practice/d9820119321945f588ed6a26f0a6991f?tpId=117&tqId=39362&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fdifficulty%3D2%26page%3D2%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=2&judgeStatus=undefined&tags=&title=
 */


public class TreeLowestCommonAncestor {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here

        if(root.val==p &&isChild(root,q)){
            return p;
        }
        if(root.val == q&&isChild(root,p)){
            return q;
        }

        if(p>root.val && q>root.val){
            return lowestCommonAncestor(root.right, p,q);
        }

        if(p<root.val && q<root.val){
            return lowestCommonAncestor(root.left, p,q);
        }

        return root.val;
    }

    boolean isChild(TreeNode root, int p){
        if(root.left == null && root.right == null){
            return false;
        }
        if(root.left != null &&root.left.val == p){
            return true;
        }
        if(root.right !=null && root.right.val == p){
            return true;
        }
        return isChild(root.left,p) || isChild(root.right, p);
    }
}
