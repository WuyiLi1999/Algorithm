package com.leetcode.Array;

//209：满足和大于指定值的长度最小的子数组
//找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
// 并返回其长度。如果不存在符合条件的子数组，返回 0

public class Test209_minSubArrayLen {
    //滑动窗口(双指针) 来确定子数组--时间复杂度O(n)，空间复杂度O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int left =0,right=-1;//滑动窗口[left...right]为我们的滑动窗口,
        int sum=0;//滑动窗口的元素和
        int minLength=nums.length+1;//最小长度，初始值为数组长度+1
        while (left< nums.length){
            //当滑动窗口中的元素和小于目标值target，滑动窗口继续添加一个元素（++right）
            if (right+1< nums.length&&sum<target){
                sum+=nums[++right];
            }else {
                //当滑动窗口中的元素和大于等于目标值target，滑动窗口缩减一个元素（left++），来找到最小子数组
                sum-=nums[left++];
            }
            //如果当前滑动窗口中的元素和大于等于target，判断当前的滑动窗口是否是最小数组长度
            if (sum>=target)
                minLength=Math.min(minLength,right-left+1);
        }
        if (minLength== nums.length+1)//证明没有找到 返回0
            return 0;
        else
            return minLength;//返回记录的最小子数组长度
    }


    public static void main(String[] args) {
        int [] nums={2,3,1,2,4,3};
        System.out.println(new Test209_minSubArrayLen().minSubArrayLen(7,nums));
    }
}
