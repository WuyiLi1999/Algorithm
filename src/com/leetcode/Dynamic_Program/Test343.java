package com.leetcode.Dynamic_Program;

/**343：整数拆分：
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * 返回 你可以获得的最大乘积 。
 */
public class Test343 {
    //方案一：动态规划--时间复杂度O(n^2)，空间复杂度O(n)
    public int integerBreak(int n) {
        //dp[i]中保存的是正整数i进行拆分后的整数的最大乘积
        int [] dp=new int[n+1];
        //初始值1不可分，结果为1
        dp[1]=1;
        //依次计算dp[2....n]的结果
        for (int i = 2; i < dp.length; i++) {
            //将i分解为j和i-j，计算每一次分解的最大值，保存在nums[i]中
            //j*(i-j)--当前分解的两个数的乘积  j*nums[i-j]--分解为j和i-j最大值的乘积  nums[i]上一次循环得到的最大值
            for (int j = 1; j < i; j++) {
                dp[i]=Math.max(j*(i-j),Math.max(dp[i],j*dp[i-j]));
            }
        }
        //返回数字n的拆分后的最大乘积
        return dp[n];
    }
    //方案二：递归+记忆搜索--时间复杂度O(2^n) 空间复杂度O(n)
    int [] nums;//记忆数组--防止进行重复计算
    public int integerBreak_1(int n) {
        //开辟内存空间
        nums=new int[n+1];
        //递归计算数字n拆分后的最大乘积
        return breakResult(n);
    }
    private int breakResult(int n) {
        //1. 递归结束条件
        if (n==1)
            return 1;
        if(nums[n]!=0)//记忆数组，避免重复计算，如果已经计算过了就直接返回数组中的结果
            return nums[n];
        //2. 计算当前数的最大乘积，将当前数字拆分为i与n-i
        int result=0;
        for (int i = 1; i < n; i++) {
            result=Math.max(i*(n-i),Math.max(result,i*breakResult(n-i)));
        }
        nums[n]=result;//保存当前n分割的最大值
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(new Test343().integerBreak_1(10));
    }
}
