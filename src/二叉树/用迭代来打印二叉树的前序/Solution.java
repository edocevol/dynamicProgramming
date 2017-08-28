package 二叉树.用迭代来打印二叉树的前序;

import adt.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by shugenniu on 2017/8/24.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if(root.right!=null )stack.push(root.right);
            if(root.left!=null ) stack.push(root.left);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
