package 机器人.矩阵最小路径和;

/**
 * Created by shugenniu on 2017/8/23.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int len1 = grid.length;
        int len2 = grid[0].length;
        if (len1 <= 0 || len2 <= 0) {
            return 0;
        }
        //dp[i][j]表示从i到j的最小路径之和
        int[][] dp = new int[len1][len2];
        dp[0][0] = grid[0][0];
        //处理矩阵的0th列
        for (int i = 1; i < len1; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //处理矩阵的0th行
        for (int j = 1; j < len2; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[len1-1][len2-1];
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 5},
                {3, 2, 1}
        };
        int res = new Solution().minPathSum(m);
        System.out.println(res);
    }
}
