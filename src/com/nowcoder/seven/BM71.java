package com.nowcoder.seven;

import java.util.Arrays;

/**BM71:最长上升子序列
 *给定一个长度为 n 的数组 arr，求它的最长严格上升子序列的长度。
 */
public class BM71 {
    //动态规划：时间复杂度O(n^2)，空间复杂度O(n)
    public int LIS (int[] arr) {
        // write code here
        int length=arr.length;
        //dp[i]记录以arr[i]结尾的最长上升子序列--初始值全部为1
        int[] dp=new int[length];
        Arrays.fill(dp,1);
        //遍历dp数组，计算dp[i]的值
        for (int i = 1; i < dp.length; i++) {
            //循环遍历dp[i]之前的位置，如果当前arr[i]元素小于arr[j]将j位置对应的dp[j]值+1,与dp[i]位置相比较，保存最大值
            //转移方程:dp[i]=Math.max(dp[i],dp[j]+1)
            for (int j = 0; j < i; j++) {
                if (arr[j]<arr[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        //寻找到dp数组中的最大元素
        int max=0;
        for (int i = 0; i < dp.length; i++) {
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arr={6,3,1,5,2,3,7,1};
        System.out.println(new BM71().LIS(arr));
    }
}
