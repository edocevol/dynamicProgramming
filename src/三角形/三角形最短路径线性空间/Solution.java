package 三角形.三角形最短路径线性空间;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shugenniu on 2017/8/24.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() <= 0) {
            return 0;
        }
        int row = triangle.size();
        int[] dp = new int[row];
        //对最下面的一行数据进行初始化
        for (int j = 0; j < row; j++) {
            dp[j] = triangle.get(row - 1).get(j);
        }

        //开始进行迭代
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];


    }

    public static void main(String[] args) {

    }
}
