package com.nowcoder.seven;

import java.util.Arrays;

/**Bm79：打家劫舍二
 * 你是一个经验丰富的小偷，准备偷沿湖的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，
 * 即，如果偷了第一家，就不能再偷第二家，如果偷了第二家，那么就不能偷第一家和第三家。沿湖的房间组成一个闭合的圆形，即第一个房间和最后一个房间视为相邻。
 * 给定一个长度为n的整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 */
public class BM79 {
    //时间复杂度O(n)，空间复杂度O(n)
    public int rob (int[] nums) {
        // write code here
        int length=nums.length;
        int [] dp=new int[length+1];
        dp[0]=0;
        //第一家偷取，最后一家不偷取的情况找到最大值
        dp[1]=nums[0];
        for (int i = 2; i < dp.length-1; i++) {
            if (dp[i-1]>dp[i-2]+nums[i-1])
                dp[i]=dp[i-1];
            else
                dp[i]=dp[i-2]+nums[i-1];
        }
        int max=dp[length-1];
        //第一家不偷取，最后一家偷取的情况 找到对应的最大值
        Arrays.fill(dp,0);
        for (int i = 2; i < dp.length; i++) {
            if (dp[i-1]>dp[i-2]+nums[i-1])
                dp[i]=dp[i-1];
            else
                dp[i]=dp[i-2]+nums[i-1];
        }
        //返回两种情况中的最大值
        return Math.max(max,dp[length]);
    }
}
