package com.seven;

import java.util.Arrays;

/**BM70：兑换零钱
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 */
public class BM70 {
    public int minMoney (int[] arr, int aim) {
        // write code here
        //如果需要兑换的钱小于1，都返回0
        if (aim<1)
            return 0;
        //dp[i]表示兑换i元需要的最小货币数量--初始值设置数量最大，为aim+1（如果都是一元兑换）
        int [] dp=new int[aim+1];
        Arrays.fill(dp,aim+1);
        Arrays.sort(arr);
        //初始化dp[0]=0
        dp[0]=0;
        //遍历dp[1...aim]计算兑换货币组合的数量，每一次取其中的最小值
        //状态转移方程：dp[i]=min(dp[i],dp[i-arr[j]]+1)
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i>=arr[j])
                    dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
            }
        }
        //如果最后比较dp[aim]的值是否超过aim，如果超过说明无解,否则返回dp[aim]
        return dp[aim]>aim?-1:dp[aim];
    }

    public static void main(String[] args) {
        int [] arr={5,2,3,10};
        System.out.println(new BM70().minMoney(arr,30));
    }
}
