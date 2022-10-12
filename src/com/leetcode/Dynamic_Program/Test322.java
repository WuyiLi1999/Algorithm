package com.leetcode.Dynamic_Program;

import java.util.Arrays;

/**322:兑换零钱
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class Test322 {
    //动态规划：时间复杂度O(Sn)  空间复杂度O(S)  其中S是金额，n是不同面额的个数
    public int coinChange(int[] coins, int amount) {
        //dp[i]表示的是总金额为i，最小可以使用多少个硬币进行组合
        int [] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);//初始值为比都是有一元硬币组成的还要多一
        dp[0]=0;//0元需要0个硬币组成
        //根据状态转移方程循环计算dp[i]的值
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //状态转移方程：dp[i]=min(dp[i],dp[i-coins[j]]+1)
                if (i>=coins[j])
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        //如果dp[amount]值为最初的初始值证明没有找到，返回-1，否则返回dp[amount]
        return dp[amount]!=amount+1? dp[amount]:-1;
    }

    public static void main(String[] args) {
        int [] coins={1, 2, 5};

        System.out.println(new Test322().coinChange(coins,11));
    }
}
