package com.leetcode.Dynamic_Program;

/**动态规划：0-1背包问题
 *给定对应物品对应的重量和价值，选取相应的物品使得重量不超过指定的W并且保证价值最大
 */
public class Knapsack01 {
    //传统的动态规划算法：时间复杂度O(nW)，空间复杂度O(nW)
    public int knapsack01(int [] weight,int [] value,int W){
        int n=weight.length;
        //dp[i][j]存储的是从物品在[0...i]选取物品价值不超过j的最大物品价值
        int [][] dp=new int[n][W+1];
        for (int i = 0; i <= W; i++) {
            dp[0][i]=weight[0]<=i?value[0]:0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j]=dp[i-1][j];
                //转移方程：dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
                //当前位置的最大价值为添加当前物品和不添加当前物品两者中的最大值
                if (j>=weight[i])
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-weight[i]]+value[i]);
            }
        }
        return dp[n-1][W];
    }

    //动态规划算法优化方案一（使用一个两行的二维数组来保存结果）：时间复杂度O(nW)，空间复杂度O(2W)
    public int knapsack01_Improve1(int [] weight,int [] value,int W){
        int n=weight.length;
        //dp[i][j]存储的是从物品在[0...i]选取物品价值不超过j的最大物品价值
        int [][] dp=new int[2][W+1];
        for (int i = 0; i <= W; i++) {
            dp[0][i]=weight[0]<=i?value[0]:0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i%2][j]=dp[(i-1)%2][j];
                //转移方程：dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
                //当前位置的最大价值为添加当前物品和不添加当前物品两者中的最大值
                if (j>=weight[i])
                    dp[i%2][j]=Math.max(dp[i%2][j],dp[(i-1)%2][j-weight[i]]+value[i]);
            }
        }
        return dp[(n-1)%2][W];
    }
    //动态规划算法优化方案二（使用一维数组来保存结果）：时间复杂度O(nW)，空间复杂度O(W)
    public int knapsack01_Improve2(int [] weight,int [] value,int W){
        int n=weight.length;
        //dp[j]存储的是从物品在[0...i]选取物品价值不超过j的最大物品价值
        int [] dp=new int[W+1];
        for (int i = 0; i <= W; i++) {
            dp[i]=weight[0]<=i?value[0]:0;
        }
        //需要从后向前遍历，计算指定重量所能保存的最大价值
        for (int i = 1; i < n; i++) {
            for (int j = W; j >= weight[i]; j--) {
                //转移方程：dp[j]=max(dp[j],dp[j-weight[i]]+value[i])
                //当前位置的最大价值为添加当前物品和不添加当前物品两者中的最大值
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[W];
    }
    public static void main(String[] args) {
        int [] weight={1,2,3};
        int [] value={6,10,12};
        System.out.println(new Knapsack01().knapsack01_Improve2(weight,value,5));
    }
}
