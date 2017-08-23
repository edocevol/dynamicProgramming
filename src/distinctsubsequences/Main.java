package distinctsubsequences;

/**
 * Created by shugenniu on 2017/8/19.
 */
public class Main {
    public static int numDistinct(String S, String T) {
        //用dp[i]表示使用S[i]时，T[0~j]在S[0~i]中匹配的数目

        int len = T.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i < S.length() + 1; i++) {
            for (int j = Math.min(i, len); j > 0; j--) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[len];
    }

    /*
     *  思路：dp题。
     *  状态定义：dp[i][j]代表s[0~i-1]中T[0~j-1]不同子串的个数。
     *  递推关系式：S[i-1]!= T[j-1]：  DP[i][j] = DP[i][j-1] （不选择S中的s[i-1]字符）
     *              S[i-1]==T[j-1]： DP[i][j] = DP[i-1][j-1]（选择S中的s[i-1]字符） + DP[i][j-1]
     *  初始状态：第0列：DP[i][0] = 0，第0行：DP[0][j] = 1
     */
    public static int numDistinct2(String S, String T) {
        int row = S.length() + 1;
        int col = T.length() + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < col; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";

        System.out.println(numDistinct(S,T));
        System.out.println(numDistinct2(S,T));
    }
}
