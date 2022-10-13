package com.leetcode.Dynamic_Program;

/**494:目标和
 *
 */
public class Test494 {
    //动态规划：时间复杂度与空间复杂度 O(n*neg)
    public int findTargetSumWays(int[] nums, int target) {
        //neg=(sum-target)/2  其中neg表示的是添加负号的所有元素和
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        int diff=sum-target;
        //如果数组中的和小于target，diff不是偶数  直接返回0，无法计算目标和
        if (diff<0||diff%2==1)
            return 0;
        int nef=diff/2;
        int n= nums.length;;
        int [][] dp=new int[n+1][nef+1];
        dp[0][0]=1;//当不进行元素选取，值一定等于0 --所以初值为1
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= nef; j++) {
                //如果j>=nums[i-1] 有两种选择：使用当前num[i-1] 和 不使用当前num[i-1]
                //所以转移方程：dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]]
                if (j>=nums[i-1])
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                else
                    //如果 j<num[i-1]，则不能选num[i-1]，此时有 转移方程：dp[i][j]=dp[i−1][j]
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][nef];
    }
}
