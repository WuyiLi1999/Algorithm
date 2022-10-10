package com.leetcode.Dynamic_Program;

/**BM63：不同路径二（带有障碍物）
 *
 */
public class Test63 {
    //时间复杂度O(mn)，空间复杂度O(mn)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        //dp[i][j]中保存的是到达第i行第j列的路径数
        int [][] dp=new int[m][n];
        //对第一行进行初始化
        for (int i = 0; i < m && obstacleGrid[i][0]==0; i++) {
            dp[i][0]=1;
        }
        //对第一列进行初始化
        for (int i = 0; i < n && obstacleGrid[0][i]==0; i++) {
            dp[0][i]=1;
        }
        // 根据状态转移方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    //使用动态规划+滚动数组进行空间复杂度降维处理
    //时间复杂度O(mn)、空间复杂度O(n)
    public int uniquePathsWithObstacles_Improve(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        //dp[i]中保存的是到达第j列的路径数
        int [] dp=new int[n];
        dp[0]=obstacleGrid[0][0]==0?1:0;
        // 根据状态转移方程 dp[j] = dp[i - 1][j] + dp[i][j - 1] 进行递推。(dp[i-1][j]==dp[j]前一行,dp[i][j - 1]==dp[j-1]当前行)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[j]=0;
                    continue;
                }
                if (j-1>=0 && obstacleGrid[i][j]==0)
                    dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int [][] nums={
                {0,0,0}, {0,1,0},{0,0,0}
        };
        System.out.println(new Test63().uniquePathsWithObstacles(nums));
    }
}
