package com.seven;

/**BM64：爬楼梯的最小花费
 *给定一个整数数组 cost，其中 cost[i] 是从楼梯第i个台阶向上爬需要支付的费用，下标从0开始。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class BM64 {
    //时间复杂度O(n)，空闲复杂度O(n)
    public int minCostClimbingStairs (int[] cost) {
        // write code here
        //记录到达台阶i所需要的最小花费，在初始状态：可以从第0台阶或者第一台阶开始，所以到达第0或者1花费为0
        int [] minCost=new int[cost.length+1];
        //在初始状态：可以从第0台阶或者第一台阶开始，所以到达第0或者1花费为0----所以从第2节台阶开始
        //转移状态：每次到一个台阶，只有两种情况，要么是它前一级台阶向上一步，要么是它前两级的台阶向上两步，因为在前面的台阶最小花费我们都得到了，
        // 因此每次更新最小值即可，转移方程为：dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])。
        for (int i = 2; i < minCost.length; i++) {
            //转移方程：dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])。
            minCost[i]=Math.min(cost[i-1]+minCost[i-1],cost[i-2]+minCost[i-2]);
        }
        return minCost[cost.length];
    }

    public static void main(String[] args) {
        int [] cost=new int[]{1,100,1,1,1,5,1,1,6,1};
        System.out.println(new BM64().minCostClimbingStairs(cost));
    }

}
