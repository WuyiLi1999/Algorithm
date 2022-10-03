package com.seven;

/**BBM68:矩阵的最小路径和
 *
 */
public class BM68 {
    public int minPathSum (int[][] matrix) {
        // write code here
        int m=matrix.length;
        int n=matrix[0].length;
        int [][] dp=new int[m+1][n+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (i==1){
                    dp[i][j]=dp[i][j-1]+matrix[i-1][j-1];
                    continue;
                }
                if (j==1){
                    dp[i][j]=dp[i-1][j]+matrix[i-1][j-1];
                    continue;
                }
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
