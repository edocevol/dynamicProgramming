package 字符串.字符串正交;

/**
 * Created by admin on 2017/8/27.
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        //dp[i][j]表示s1的前i个字符串和s2的前j个字符适合和s3的前i+j个字符一致
        //因此这里的dp数组的大小计算最好从1开始
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        //s[0][j]表示s2的前j个元素和s3的前j个元素匹配
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {

    }
}
