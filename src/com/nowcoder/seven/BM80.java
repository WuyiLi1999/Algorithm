package com.nowcoder.seven;

import java.util.Arrays;

/**
 * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
 * 2.如果不能获取到任何利润，请返回0
 * 3.假设买入卖出均无手续费
 */
public class BM80 {
    //策略一：贪心算法
    public int maxProfit (int[] prices) {
        // write code here
        //1. 将第一天看成价格最低，
        int minPrice=prices[0];
        int maxPrice=0;
        //2. 遍历的时候遇到价格更低则更新价格最低并计算最大收益
        for (int i = 1; i < prices.length; i++) {
            //2.1 每次都比较最大收益与当日价格减去价格最低的值，选取最大值作为最大收益。
            if (prices[i]>minPrice){
                maxPrice=Math.max(prices[i]-minPrice,maxPrice);
            }else
                //2.2 保存最低价格
                minPrice=prices[i];
        }
        return maxPrice;
    }
    //策略二：动态规划
    public int maxProfit_1 (int[] prices) {
        // write code here
        //dp[i]保存的是在第i天卖出可以获取的最大收益（在最小价格的时候买入）
        int [] dp=new int[prices.length+1];
        //记录最小价格为第一天的价格（在第一天买入）
        int minPrice=prices[0];
        //数组中最大收益初始都为0
        Arrays.fill(dp,0);
        //从第二天开始遍历，计算dp[i]的值和最小价格
        for (int i = 2; i < dp.length; i++) {
            //如果当前的价格大于最小价格，可以卖出，保存最大收益
            if (prices[i-1]>minPrice){
                dp[i]=prices[i-1]-minPrice;
            }else
                //否则的话，记录该金额是最小价格
                minPrice=prices[i-1];
        }
        int maxPrice=dp[0];
        for (int i = 0; i < dp.length; i++) {
            maxPrice=Math.max(maxPrice,dp[i]);
        }
        return maxPrice;
    }
    public int maxProfit_2 (int[] prices) {
        // write code here
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
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        //最后一天不持股，到该天为止的最大收益
        return dp[n - 1][0];
    }
}
