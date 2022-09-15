package com.two;
//BM18:二维数组中的查找
public class BM18 {

    public boolean Find(int target, int [][] array) {
        if (array.length==0)
            return false;
        int row=array.length-1;//数组的行数
        int cols=array[0].length;//数组的列数
        int col=0;
        while(row>=0&&col<cols){
            if(array[row][col]<target)
                col++;
            else if(array[row][col]>target)
                row--;
            else
                return true;
        }
        return false;
    }
}
