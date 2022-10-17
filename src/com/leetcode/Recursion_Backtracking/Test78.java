package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**78:子集
 *给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Test78 {
    //递归+回溯：时间复杂度O(n*n!)，空间复杂度O(n)
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //空集是任意的子集
        lists.add(list);
        if (n==0)
            return lists;
        //递归遍历寻找以index开头的子集，其实为数组的第一个元素
        subsets(lists,list,nums,0);
        return lists;
    }
    //递归寻找，以数组第index元素为开始的子集
    private void subsets(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        //递归结束条件：当前第index位置大于数组的长度了，证明遍历完整个数组了，递归结束
        if (index>=nums.length){
            lists.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            subsets(lists,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int [] nums={-10,3,8,0};
        List<List<Integer>> lists = new Test78().subsets(nums);
        for (List<Integer> list :lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
