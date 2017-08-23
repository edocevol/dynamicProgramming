package 股票.最多两次交易;

/**
 * Created by shugenniu on 2017/8/22.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int price : prices) {
            //firstBuy记录的时，对比交易后的净利润
            if (firstBuy < -price) firstBuy = -price;
            //firstSell为第一笔卖出后的总收入
            if (firstSell < firstBuy + price) firstSell = firstBuy + price;

            //当前一笔的买入和卖出有了收益之后，才考虑第二笔投资
            //且只有在当前收入大于第二笔买入价格时，才考虑第二笔交易
            if (secondBuy < firstSell - price) secondBuy = firstSell - price;

            //第二笔的收益就是 第二笔买完后，剩余的收益（去掉第二笔的支出） + 最后卖出的收益（最后的价格为纯收益）
            if (secondSell < secondBuy + price) secondSell = secondBuy + price;
            //System.out.println(firstBuy+ " " +firstSell + " " + secondBuy + " " + secondSell);
        }
        return secondSell;
    }


    public static void main(String[] args) {
        int[] prices = {2, 4, 5, 7, 4, 6, 4, 8, 9, 1};
        int res = new Solution().maxProfit(prices);
        System.out.println(res);
    }

}
