package com.leetcode.Dynamic_Program;

import java.util.Arrays;

/**279：完全平方数
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class Test279 {
    //动态规划：时间复杂度O(nlogn)，空闲复杂度O(n)
    public int numSquares(int n) {
        //dp[i]保存当前i值的最小完全平方数数量
        int [] dp=new int[n+1];
        //循环遍历计算dp[i]的值
        for (int i = 1; i < dp.length; i++) {
            dp[i]=i;//当前i的初值为i（假设由i个1相加而成）
            for (int j = 1; j*j <= i; j++) {
                //状态转移方程：dp[i]=Math.min(dp[i-j*j]+1,dp[i])
                dp[i]=Math.min(dp[i-j*j]+1,dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Test279().numSquares(13));
    }
}
