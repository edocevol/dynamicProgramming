package 机器人.通过障碍的不同路径数;

/**
 * Created by shugenniu on 2017/8/23.
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //一些临界条件的判断
        if (obstacleGrid == null) {
            return 0;
        }
        int len1 = obstacleGrid.length;
        int len2 = obstacleGrid[0].length;
        if (len1 <= 0 || len2 <= 0) {
            return 0;
        }
        //生成一个二维的dp数组
        int[][] dp = new int[len1][len2];
        boolean blocked = false;
        for (int i = 0; i < len1; i++) {
            //第一行的每一列一旦之前有1发现，后面的所有的数据都要填充为0，表示无法到达当前节点
            if (obstacleGrid[i][0] == 1) {
                blocked = true;
            }
            dp[i][0] = blocked ? 0 : 1;
        }
        blocked = false;
        for (int j = 0; j < len2; j++) {
            //第一列的每一行一旦之前有1发现，后面的所有的数据都要填充为0，表示无法到达当前节点
            if (obstacleGrid[0][j] == 1) {
                blocked = true;
            }
            dp[0][j] = blocked ? 0 : 1;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                //如果不是1，则为左单元格+上单元格的数据之后，否则为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        int[][] m = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int res = new Solution().uniquePathsWithObstacles(m);
        System.out.println(res);
    }
}
