package com.leetcode.Dynamic_Program;

/**377:组合总和
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 * 顺序不同的序列被视作不同的组合。
 */
public class Test377 {
    //动态规划：时间复杂度O(Tn)，空间复杂度O(T)
    public int combinationSum4(int[] nums, int target) {
        //dp[i]中存放的是i可以有的排列组合数
        int [] dp=new int[target+1];
        dp[0]=1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                //转移方程：dp[i]+=dp[i-nums[j]]
                if (i>=nums[j])
                    dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int [] nums={1,2,3};

        System.out.println(new Test377().combinationSum4(nums,4));
    }

}
