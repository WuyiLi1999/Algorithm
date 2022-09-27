package com.sxi;

import java.util.ArrayList;
import java.util.Arrays;

/**BM58:没有重复项数字的全排列--全排列就是对数组元素交换位置，使每一种排列都可能出现。
 * 因为题目要求按照字典序排列输出，那毫无疑问第一个排列就是数组的升序排列，它的字典序最小
 * 给出一组数字，返回该组数字的所有排列
 */
public class BM58 {
    //递归与回溯算法
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        //对数组元素进行排序
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        //
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        premute(lists,list,0);
        return lists;
    }
    //确定了在list中的index（包括）之前的元素的位置
    private void premute(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, int index) {
        //终止条件：要交换位置的下标到了数组末尾，没有可交换的了，那这就构成了一个排列情况，可以加入输出数组。
        if (index==list.size()-1)
            lists.add(list);
        else {
            //遍历从它开始的后续元素，每一级就与它交换一次位置
            for (int i = index; i < list.size(); i++) {
                //交换位置
                swap(list,index,i);
                //进行递归遍历
                premute(lists,list,index+1);
                //交换的情况再换回来进行回溯，进入其他分支
                swap(list,index,i);
            }
        }
    }
    private void swap(ArrayList<Integer> list,int i,int j){
        int num=list.get(i);
        list.set(i,list.get(j));
        list.set(j,num);
    }

}
