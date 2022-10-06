package com.seven;

/**BM78：打家劫舍
 *你是一个经验丰富的小偷，准备偷沿街的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，
 * 即，如果偷了第一家，就不能再偷第二家；如果偷了第二家，那么就不能偷第一家和第三家。
 * 给定一个整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
 */
public class BM78 {
    public int rob (int[] nums) {
        // write code here
        //dp[i]表示当前小偷到第i（从1开始）家所能偷取的最大金额，dp[0]=0，dp[1]=nums[0]
        int [] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        //遍历所有的房屋，依次计算dp[i]的值，
        for (int i = 2; i < dp.length; i++) {
            //计算到了当前第i家所能偷取的最大金额，有两种选择--偷或者不偷，比较两者的最大值
            // 选择不偷--值为第i-1家所能偷取的最大金额dp[i-1]
            // 选择偷--值为当前房屋的金额nums[i-1] + 从当前房屋开始的前面两家之前的最大金额dp[i-2]
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int [] nums={1,2,3,4};
        System.out.println(new BM78().rob(nums));
    }
}
