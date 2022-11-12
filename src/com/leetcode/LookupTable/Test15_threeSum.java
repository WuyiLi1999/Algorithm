package com.leetcode.LookupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15:三数之和等于0
public class Test15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        if (nums==null||nums.length==0)
            return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int k= nums.length-1;
            int target=-nums[i];

            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1&&nums[j]==nums[j-1])
                    continue;
                while (j<k&&nums[j]+nums[k]>target)
                    k--;
                if (j==k)
                    break;
                if (nums[j]+nums[k]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                }

            }
        }
        return lists;
    }
}
