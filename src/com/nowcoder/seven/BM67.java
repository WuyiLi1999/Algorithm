package com.nowcoder.seven;

/**BM67:不同路径的数目
 * 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。可以有多少种不同的路径从起点走到终点？
 */
public class BM67 {
    //动态规划：时间复杂度O(mn)，空间复杂度O(mn)
    public int uniquePaths (int m, int n) {
        // write code here
        //定义保存结果的数组 dp[i][j]表示第i行第j列的不同路径数
        int [][] dp=new int[m+1][n+1];
        //遍历整个数组，计算结果
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //初始提条件：当i或者j为1的时候，代表矩阵只有一行或者一列，因此只有一种路径
                //如果只有一行的话，所有的结果都为1，并跳过接下里的逻辑语句
               if (i==1){
                   dp[i][j]=1;
                   continue;
               }
               //如果只有一列的话，所有的结果也都为1，并跳过接下来的逻辑语句
               if (j==1){
                   dp[i][j]=1;
                   continue;
               }
               //每个格子的路径数只会来自它左边的格子数和上边的格子数，因此状态转移为
               //动态转移方程： dp[i][j]=dp[i-1][j]+dp[i][j-1]
               dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    //方法二：递归求解
    public int uniquePaths_1 (int m, int n){
        //终止条件：当矩阵变长n减少到1的时候，很明显只能往下走，没有别的选择了，只有1条路径；同理m减少到1时也是如此。因此此时返回数量为1
        if (m==1||n==1)
            return 1;
        //返回值：对于每一级都将其两个子问题返回的结果相加返回给上一级
        //递归过程：每一级都有向下或者向右两种路径选择，分别进入相应分支的子问题
        return uniquePaths_1(m-1,n)+uniquePaths(m,n-1);
    }
}
