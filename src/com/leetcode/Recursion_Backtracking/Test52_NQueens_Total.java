package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test52_NQueens_Total {

    int res=0;
    public int totalNQueens(int n){
        if(n==0)
            return res;
        //col代表列，dia1代表右上对角线，dia2代表右下对角线
        boolean [] col=new boolean[n];
        boolean [] dia1=new boolean[2*n-1];//diai[i+j]
        boolean [] dia2=new boolean[2*n-1];//dia2[i-j+n-1]
        int [] rows=new int[n];

        solveNQueens(n,0,rows,col,dia1,dia2);
        return res;
    }
    //计算n皇后问题在第index行中，皇后存放的位置，保存在rows[index]中
    private void solveNQueens(int n, int index, int[] rows, boolean[] col, boolean[] dia1, boolean[] dia2) {
        //递归结束条件--当index行信息等于皇后个数时，证明已经寻找完毕（N皇后的行信息index值为[0..n-1]）
        if (index==n){
            res++;
            return;
        }
        //计算N皇后问题中第index行中皇后可以放列的位置
        for (int i = 0; i < n; i++) {
            //如果第index行的第i列中，该位置所在的列没有被使用，并且该列所在的右上、右下对角线未被占用
            if (!col[i]&&!dia1[index+i]&&!dia2[index-i+n-1]){
                //当前index行的第i列满足皇后放置的条件-记录当前行皇后的位置，并将该皇后所在的位置的列信息，右上右下对角线信息设为true
                rows[index]=i;
                col[i]=true;
                dia1[index+i]=true;
                dia2[index-i+n-1]=true;
                //递归继续遍历index+1行
                solveNQueens(n,index+1,rows,col,dia1,dia2);
                //回溯，计算该index行第i列之后有没有位置满足皇后放置条件，继续遍历第i+1列
                rows[index]=0;
                col[i]=false;
                dia1[index+i]=false;
                dia2[index-i+n-1]=false;
            }
        }
        return;
    }


    public static void main(String[] args) {
        System.out.println(new Test52_NQueens_Total().totalNQueens(4));
    }
}
