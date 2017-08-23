package 股票.允许K次交易;

/**
 * Created by shugenniu on 2017/8/22.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        //
        int[][] t = new int[k + 1][len];
        //t[i][j]表示第i次交易时，用到j时的收益
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];//初始的最大值是-prices[0]
            for (int j = 1; j < len; j++) {
                //当前的最大收益为不包括当前股票的收益，或者是当前的价格卖出
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                //当前的净利润是之前的净利润，或者上一次交易后的盈利去掉当前的操作
                tmpMax = Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }

    /**
     * 如果K>len/2则说明，K次交易可以随意次数的交易，退化到求最大值利润
     *
     * @param prices
     * @return
     */
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {2, 4, 5, 7, 4, 6, 4, 8, 9, 1};
        int res = new Solution().maxProfit(100, prices);
        System.out.println(res);
    }

}
