package palindromepartitioning;

/**
 * Created by shugenniu on 2017/8/19.
 */
public class Main {
    public static int minCut(String s) {
        if(s == null || s.length() == 0)
            return 0;

        // 计算s[i-j]是否回文
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j >= 0; j--){
                // 当i处字符与j处字符相等，且i-j字符串数目小于3（aba）或者s[j+1,i-1]为回文序列
                if((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || isPal[j+1][i-1]))
                    isPal[j][i] = true;
            }
        }

        // dp[i]表示将s的0~i-1分为回文序列的最少切割数
        // dp[i]等于(d[j]+1)的最小值，并且j-i-1必须为回文序列
        int[] dp = new int[s.length()+1];
        dp[0] = -1;
        for(int i = 1; i <= s.length(); i++){
            int min = Integer.MAX_VALUE;
            for(int j = i - 1; j >= 0; j--){
                // 当j~i-1为回文序列，那在j处切割，并计算最小切割数
                if(isPal[j][i-1] && dp[j] + 1 < min)
                    min = dp[j] + 1;

            }
            dp[i] = min;
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
}
