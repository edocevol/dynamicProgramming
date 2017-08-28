package 二叉树.从1到N二叉树的不同排列数;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shugenniu on 2017/8/24.
 */
public class Solution {
    /**
     * 考虑到二叉树的性质，对于任意以i为根节点的二叉树，
     * 它的左子树的值一定小于i，也就是[0, i - 1]区间，而右子树的值一定大于i，也就是[i + 1, n]。
     * 假设左子树有m种排列方式，而右子树有n种，则对于i为根节点的二叉树总的排列方式就是m x n。
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        //cantalan树
        //C(2n,n)/(n+1)
        long ans = 1;
        for (int i = n + 1; i <= 2 * n; i++) {
            ans = ans * i / (i - n);
        }
        return (int) (ans / (n+1));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
        System.out.println(new Solution().numTrees2(3));
    }
}
