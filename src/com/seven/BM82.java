package com.seven;

public class BM82 {
    //动态规划：时间复杂度O(n)，空间复杂度O(n)
    public int FindGreatestSumOfSubArray(int[] array) {
        //dp[i]用来保存以i结尾的子数组的最大和，dp[0]=array[0]
        int [] dp=new int[array.length];
        dp[0]=array[0];
        int max=0;//用来保存子数组的最大和
        for (int i = 1; i < dp.length; i++) {
            //状态转移方程：dp[i]=Math.max(array[i],dp[i-1]+array[i])
            dp[i]=Math.max(array[i],dp[i-1]+array[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    //动态规划优化--时间复杂度O(n)，空间复杂度O(1)
    public int FindGreatestSumOfSubArray_Improve(int[] array) {
        int sum = 0;
        int max = array[0];
        for(int i=0;i<array.length;i++){
            // 优化动态规划，确定sum的最大值
            sum = Math.max(sum + array[i], array[i]);
            // 每次比较，保存出现的最大值
            max = Math.max(max,sum);
        }
        return max;
    }
}
