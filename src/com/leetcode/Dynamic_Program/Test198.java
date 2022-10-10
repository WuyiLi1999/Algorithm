package com.leetcode.Dynamic_Program;

/**198：打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Test198 {
    //时间复杂度O(n)，空间复杂度O(n)
    public int rob(int[] nums) {
        int n=nums.length;
        //dp[i]表示小偷到底i家可以偷去到的最大金额 i从1开始到n
        int [] dp=new int[n+1];
        dp[0]=0;//赋初值
        dp[1]=nums[0];
        //在第i家有两种选择，偷取--当前房子的金额+到达前面的前面那一家可以投去的最大金额，不偷取--到达前面一家可以偷取的最大金额 ；
        // 选取两种选择的最大值
        //通过转移方程计算dp[i]的值：max(dp[i-1],dp[i-2]+nums[i-1])
        for (int i = 2; i <= n; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
    //动态规划优化（滚动数组）：时间复杂度O(n)，空间复杂度O(1)
    public int rob_Improve(int[] nums){
        int [] dp=new int[2];
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i%2]=Math.max(dp[(i-1)%2],dp[i%2]+nums[i]);
        }
        return dp[(nums.length-1)%2];
    }
    //记忆数组--避免重复计算，memo[index]中保存的是从第index房子开始进行打劫，可以打劫到的最大金额
    int [] memo;
    public int rob_1(int[] nums) {
        memo=new int[nums.length];
        return tryRob(nums,0);
    }
    //尝试从第index家开始偷取的最高金额
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        if (memo[index]!=0)
            return memo[index];
        int maxMoney=0;
        for (int i=0;i<nums.length;i++){
            maxMoney=Math.max(maxMoney,nums[i]+tryRob(nums,i+2));
        }
        memo[index]=maxMoney;
        return maxMoney;
    }
}
