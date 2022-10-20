package com.leetcode.Recursion_Backtracking;

public class Test79_WordSearch {

    //表示接下来的坐标走向（前后上下）
    int [][] dxy ={{-1,0},{1,0},{0,-1},{0,1}};
    //表示数组中的元素是否已经被遍历了默认值为false
    boolean [][] flag;
    public boolean exist(char[][] board, String word){
        if (board.length==0||board==null)
            return false;
        int m= board.length;
        int n=board[0].length;
        flag=new boolean[m][n];
        //循环遍历每一个节点，判断以该节点开始的字符是否能够匹配
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //递归遍历判断以board[i][j]开始的字符是否字符串中第index个字符相匹配（起始index=0）
                if (searchWord(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }

    //搜索在二维数组board中board[x][y]位置是否和单词word[index]位置相匹配
    private boolean searchWord(char[][] board, String word, int x, int y, int index){
        //递归结束条件（遍历到最后一个字符），返回结果为当前位置是否和字符串最后一个字符相等（相等就匹配，不相等就不匹配）
        if (index==word.length()-1)
            return board[x][y]==word.charAt(index);
        //递归条件：如果数组中的字符与字符串第index位置相等，就判断是否与下一个字符相匹配
        if (board[x][y]==word.charAt(index)){

            flag[x][y]=true;//当前位置标记为已使用
            //循环遍历上下左右是否和下一个匹配
            for (int i = 0; i < 4; i++) {
                int newX=x+dxy[i][0];//计算数组新的位置
                int newY=y+dxy[i][1];
                //如果新的位置没有越界并且新的位置未被使用，就判断新的位置是否和字符串下一个位置相匹配
                if (isOverBoundary(newX,newY,board)&&!flag[newX][newY]){
                    if (searchWord(board,word,newX,newY,index+1))//如果匹配就返回true
                        return true;
                }
            }
            //循环没有找到下一个可以匹配的，证明以当前位置开头的不能与字符串从index位置之后相匹配，所以进行回溯
            //当前位置开始没有找到路径，当前节点不适合，标记为未遍历
            flag[x][y]=false;
            return false;//返回false
        }
        return false;
    }
    //判断新的xy值是否越界
    private boolean isOverBoundary(int newX, int newY, char[][] board) {
        if (newX>=0&&newX<board.length&&newY>=0&&newY<board[newX].length)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        char [][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Test79_WordSearch().exist(board,"ABCCED"));
    }
}
