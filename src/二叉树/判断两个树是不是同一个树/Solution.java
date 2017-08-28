package 二叉树.判断两个树是不是同一个树;

import adt.TreeNode;

/**
 * Created by shugenniu on 2017/8/24.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        } else {
            boolean cond1 = isSameTree(p.left, q.right);
            boolean cond2 = isSameTree(p.right, q.right);
            return cond1 && cond2;
        }

    }

    public static void main(String[] args) {

    }
}
