package com.leetcode.Array;

//209：满足和大于指定值的长度最小的子数组
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
// 并返回其长度。如果不存在符合条件的子数组，返回 0

public class Test209_minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0,right=0;//滑动窗口[left...right]为我们的滑动窗口
        int sum=0;//计算结果和
        int minLength=nums.length+1;//最小长度，初始值为数组长度+1
        while (left< nums.length){
            if (right+1< nums.length&&sum<target){
                sum+=nums[++right];
            }else {
                sum-=nums[left++];
            }
            if (sum>=target)
                minLength=Math.min(minLength,right-left+1);
        }
        if (minLength== nums.length+1)
            return 0;
        else
            return minLength;
    }
}
