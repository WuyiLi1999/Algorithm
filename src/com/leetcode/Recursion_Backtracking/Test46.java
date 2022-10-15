package com.leetcode.Recursion_Backtracking;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**46:全排列问题（不含相等元素）
 *给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案
 */
public class Test46 {
    List<List<Integer>> lists=new ArrayList<>();
    boolean [] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length==0)
            return lists;
        List<Integer> list=new ArrayList<>();
        used=new boolean[nums.length];
        generatePermutation(nums,0,list);
        return lists;
    }

    private void generatePermutation(int[] nums, int index, List<Integer> list) {
        if (index == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                list.add(nums[i]);
                used[i]=true;
                generatePermutation(nums,index+1,list);
                list.remove(index);
                used[i]=false;
            }
        }
        return;
    }
    //使用交换的思想进行递归与回溯，全排列就是对数组元素交换位置，使每一种排列都可能出现
    public List<List<Integer>> permute_swap(int[] num){
        List<List<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        //从第一个位置0开始
        permute(lists,list,0);
        return null;
    }
    //确定了在list中的index（包括）之前的元素的位置 遍历从index开始的后续元素，每一级就与它交换一次位置。
    private void permute(List<List<Integer>> lists, ArrayList<Integer> list, int index) {
        //终止条件：要交换位置的下标到了数组末尾，没有可交换的了，那这就构成了一个排列情况，可以加入输出数组。
        if (index==list.size()-1){
            lists.add(new ArrayList<>(list));
            return;
        }
        //遍历从它开始的后续元素，每一级就与它交换一次位置
        for (int i = index; i < list.size(); i++) {
            //交换位置
            swap(list,index,i);
            //进行递归遍历,继续往后遍历
            permute(lists,list,index+1);
            //交换的情况再换回来进行回溯，进入其他分支
            swap(list,index,i);
        }
    }

    private void swap(ArrayList<Integer> list, int index, int i) {
        int temp=list.get(index);
        list.set(index,list.get(i));
        list.set(i,temp);
    }

    public static void main(String[] args) {
        int [] nums={1,2};
        List<List<Integer>> list=new Test46().permute(nums);
        for (List<Integer> list1: list) {
            for (int i = 0; i < list1.size(); i++) {
                System.out.print(list1.get(i)+" ");
            }
            System.out.println();
        }
    }
}
