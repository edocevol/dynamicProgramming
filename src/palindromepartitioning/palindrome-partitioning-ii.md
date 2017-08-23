# 题目
>Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
For example, given s ="aab",
Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.

## 方案1 

### 递推方程

// dp[i]表示将s的0~i-1分为回文序列的最少切割数
// dp[i]等于(d[j]+1)的最小值，并且j-i-1必须为回文序列

### 代码
```java
public class Solution {
    public int minCut(String s) {
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
}
```

## 方案2

### 递推方程
* 回文的最小分割数
* 1.dp[i]表示当前i到len-1这段的最小分割数
* 2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
* 3.p[i][j]=true表示str[i..j]是回文
* 4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])

### 代码

```java
public class Solution {
      /**
     * 回文的最小分割数
     * 1.dp[i]表示当前i到len-1这段的最小分割数
     * 2.dp[i]=min{dp[j+1]+1}（i=<j<len）其中str[i..j]必须是回文、
     * 3.p[i][j]=true表示str[i..j]是回文
     * 4.p[i][j]=s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])
     */
    public int minCut(String s) {
        int []dp=new int[s.length()+1];
        boolean [][]p=new boolean[s.length()][s.length()];
        dp[s.length()]=-1;//确保dp[s.length()-1]=0
        for(int i=s.length()-1;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<2||p[i+1][j-1])){
                    p[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
}

```