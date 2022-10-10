package com.leetcode.Dynamic_Program;

/**213：打家劫舍二
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 */
public class Test213 {
    //时间复杂度O(n)，空间复杂度O(1)
    public int rob(int[] nums) {
        if (nums.length==1)
            return nums[0];
        if (nums.length==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(rob_Improve(nums,0,nums.length-1),rob_Improve(nums,1,nums.length));
    }
    public int rob_Improve(int[] nums,int start,int end){
        int pre=nums[start];
        int cur=Math.max(nums[start+1],pre);
        int temp;
        for (int i = start+2; i < end; i++) {
            temp=cur;
            cur=Math.max(cur,pre+nums[i]);
            pre=temp;
        }
        return cur;
    }
}
