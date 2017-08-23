package 数列计算题.区间最小值乘以区间和最大值;

/**
 * Created by shugenniu on 2017/8/22.
 */
public class Solution {

    public long resolve(int n, int[] arr) {
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0] * arr[0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], max(arr, 0, j)[0] * max(arr, 0, j)[1]);
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(arr[i] * arr[j], Math.max(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        return dp[n - 1][n - 1];
    }

    public static int[] max(int[] arr, int a, int b) {
        int sum = arr[a];
        int min = arr[a];
        for (int i = a + 1; i <= b; i++) {
            sum += arr[i];
            min = Math.min(min, arr[i]);
        }
        return new int[]{min, sum};
    }

    public static void main(String[] args) {
        long res = new Solution().resolve(3, new int[]{1, 2, 3});
        System.out.println(res);
    }
}
