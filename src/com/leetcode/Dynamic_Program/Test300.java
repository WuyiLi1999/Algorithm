package com.leetcode.Dynamic_Program;

import java.util.Arrays;

/**300：最长递增子序列
 *
 */
public class Test300 {
    //时间复杂度O(n^2) 空间复杂度O(n)
    public int lengthOfLIS(int[] nums) {
        // write code here
        int n= nums.length;
        //dp[i]表示以第i个位置为结尾的的最长递增子序列，初始值为1,（当前自己）
        int [] dp=new int[n];
        Arrays.fill(dp,1);
        int max=1;//用来保存最长自增子序列中的最大值
        //根据转移方程，循环计算dp[i]
        for (int i = 1; i < n; i++) {
            //计算数组从[0...i]中的最长自增子序列
            for (int j = 0; j < i; j++) {
                //如果当前第j位置元素小于第i位置的元素，证明是可以与第j位置元素构成递增--dp[i]=max(dp[i],dp[j]+1)，否则不能构成递增
                if (nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums={10,9,2,5,3,7,101,18};
        System.out.println(new Test300().lengthOfLIS(nums));
    }
}
