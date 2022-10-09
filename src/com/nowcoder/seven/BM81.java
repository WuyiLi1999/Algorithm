package com.nowcoder.seven;

/**BM81：买卖股票的最好时机二（可以多次交易）
 * 假设你有一个数组prices，长度为n，其中prices[i]是某只股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1. 你可以多次买卖该只股票，但是再次购买前必须卖出之前的股票
 * 2. 如果不能获取收益，请返回0
 * 3. 假设买入卖出均无手续费
 */
public class BM81 {
    public int maxProfit (int[] prices) {
        int n = prices.length;
        //dp[i][0]表示某一天不持股到该天为止的最大收益，dp[i][1]表示某天持股，到该天为止的最大收益
        int[][] dp = new int[n][2];
        //第一天不持股，总收益为0
        dp[0][0] = 0;
        //第一天持股，总收益为减去该天的股价
        dp[0][1] = -prices[0];
        //遍历后续每天，状态转移
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天不持股，到该天为止的最大收益
        return dp[n - 1][0];
    }
    public static void main(String[] args) {
        int [] prices={1,83,74,26,63,37,25,63,28};
        System.out.println(new BM81().maxProfit(prices));
    }
}
