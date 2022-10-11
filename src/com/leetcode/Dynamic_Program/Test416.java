package com.leetcode.Dynamic_Program;

/**416:分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Test416 {
    public boolean canPartition(int[] nums){
        int sum=0;
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            sum+=nums[i];
        }
        if (sum%2==1)
            return false;
        boolean [] dp=new boolean[sum/2+1];
        for (int i = 0; i <= sum/2; i++) {
            dp[i]= nums[0]==i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = sum/2; j >=nums[i] ; j--) {
                dp[j]= dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum/2];
    }

    public static void main(String[] args) {
        int [] nums={1,2,3,5,1};
        System.out.println(new Test416().canPartition(nums));
    }
}
