package 字符串.字符串的编辑距离;

/**
 * Created by admin on 2017/8/27.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //dp[i][j] 表示word1[i-1]和word[j-1]的编辑距离
        //dp[0][0]表示""和""的最小编辑距离
        //dp[i][0]表示word1[i-1] 和""的最小编辑距离
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        //dp[i][0]表示word2[j-1] 和""的最小编辑距离
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] :
                        Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[len1][len2];
    }
}
