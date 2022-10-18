package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**90：子集二
 *给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）
 */
public class Test90 {
    //时间复杂度O(n*2^n)，空间复杂度O(nlogn)--递归调用栈O(n)，排序算法O(nlogn)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        lists.add(list);
        Arrays.sort(nums);
        boolean [] flag=new boolean[nums.length];
        subsetsWithDup(lists,list,nums,flag,0);
        return lists;
    }

    private void subsetsWithDup(List<List<Integer>> lists, List<Integer> list, int[] nums, boolean [] flag, int index) {
        if (index>nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            //为了避免生成重复的子集，在迭代时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集
            if (i>0&&!flag[i-1]&&nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            flag[i]=true;
            lists.add(new ArrayList<>(list));
            subsetsWithDup(lists,list,nums,flag,i+1);
            flag[i]=false;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int [] nums={-10,0,1,1};
        List<List<Integer>> lists = new Test90().subsetsWithDup(nums);
        for (List<Integer> list :lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
