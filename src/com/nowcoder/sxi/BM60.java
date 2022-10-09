package com.nowcoder.sxi;

/**BM60:岛屿的数量--递归+深度优先遍历
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 */
public class BM60 {

    public int solve (char[][] grid) {
        // write code here
        //空矩阵的情况--直接返回0
        if (grid.length==0)
            return 0;
        //记录岛屿的个数
        int number=0;
        //遍历数组的每一个元素，只要遇到一个1就表名存在一个岛屿，岛屿数+1，并进行深度优先遍历与i，j相邻的所有1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1'){
                    number++;
                    dfs(grid,i,j);
                }
            }
        }
        return number;
    }
    //深度优先遍历：接着将该位置的1改为0，然后使用dfs判断四个方向是否为1，分别进入4个分支继续修改。
    private void dfs(char[][] grid, int i, int j) {
        grid[i][j]='0';
        if(i-1>=0&&grid[i-1][j]=='1')
            dfs(grid,i-1,j);
        if (i+1<grid.length&&grid[i+1][j]=='1')
            dfs(grid,i+1,j);
        if (j-1>=0&&grid[i][j-1]=='1')
            dfs(grid,i,j-1);
        if (j+1<grid[i].length&&grid[i][j+1]=='1')
            dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        char[][] grid={
                {'1','0','1'},
                {'0','1','0'},
                {'1','0','1'}
        };
        System.out.println(new BM60().solve(grid));
    }
}
