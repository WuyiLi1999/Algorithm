package com.leetcode.Recursion_Backtracking;

public class Test200_WaterFilling {
    //表示接下来的坐标走向（前后上下）
    int [][] dxy ={{-1,0},{1,0},{0,-1},{0,1}};
    //表示数组中的元素是否已经被访问，默认值为false
    boolean[][] flag;
    public int numIslands(char[][] grid) {
        int number=0;
        if (grid==null)
            return number;
        flag=new boolean[grid.length][grid[0].length];
        //遍历整个数组，寻找岛屿--如果找到一个岛屿就进行深度优先遍历，判断该岛屿是否与其他岛屿相连作为一个大的岛屿
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                //当前节点值为'1'并且该节点没有和之前的岛屿连接在一起作为一个大的岛屿
                if (grid[i][j]=='1'&&!flag[i][j]){
                    number++;
                    dfs(grid,i,j);//对于grid[i][j]相连的岛屿合并到该岛屿中
                }
            }
        }
        return number;
    }
    //深度优先遍历递归结束条件（回溯）--当查找当前节点的上下左右都没有与之相连的1，就结束，
    //保证（x，y）合法并且grid[x][y]是没有被访问过的陆地
    private void dfs(char[][] grid, int x, int y) {
        //该岛屿已经被记录了
        flag[x][y]=true;
        for (int i=0;i<4;i++){
            int newX=x+dxy[i][0];
            int newY=y+dxy[i][1];
            if (isOverBoundary(newX,newY,grid)&&grid[newX][newY]=='1'&&!flag[newX][newY])//当前节点的上下左右有相连的岛屿进行合并
                dfs(grid,newX,newY);
        }
        return;
    }

    //判断新的xy值是否越界
    private boolean isOverBoundary(int newX, int newY, char[][] board) {
        if (newX>=0&&newX<board.length&&newY>=0&&newY<board[0].length)
            return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] grad={{'1','0','1','1'},{'1','1','1','0'},{'0','0','0','1'},{'1','0','1','1'}};
        System.out.println(new Test200_WaterFilling().numIslands(grad));
    }
}
