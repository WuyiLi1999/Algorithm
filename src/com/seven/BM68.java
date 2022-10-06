package com.seven;

/**BBM68:矩阵的最小路径和
 *给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 * 路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 */
public class BM68 {
    //时间复杂度O(mn)
    public int minPathSum (int[][] matrix) {
        // write code here
        int m=matrix.length;
        int n=matrix[0].length;
        //dp[i][j]表示的含义是到达数组第i行第j列的位置的最小路径和
        int [][] dp=new int[m+1][n+1];
        //循环遍历数组dp，找到每一个元素的最小路径和
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                //第一行，只能向右行走，没有第二种选择，因此第一行只能由其左边的累加
                if (i==1){
                    dp[i][j]=dp[i][j-1]+matrix[i-1][j-1];
                    continue;
                }
                //第一列，只能向下走，没有其他的选择，第一列只能由其上面的累加
                if (j==1){
                    dp[i][j]=dp[i-1][j]+matrix[i-1][j-1];
                    continue;
                }
                //转移方程：dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i-1][j-1]
                //当前位置的最小路径和等于，上面和左面的最小值加上当前位置的元素值
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
