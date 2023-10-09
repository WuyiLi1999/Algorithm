package com.leetcode.LookupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15:三数之和等于0
public class Test15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        if (nums==null||nums.length==0) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //每一次遍历会把i所对应数字所有符合题意的都找出来，如果接下来还是一样的那个可以跳过，减少重复计算
            if(i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            int k= nums.length-1;
            int target=-nums[i];

            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1&&nums[j]==nums[j-1]) {
                    continue;
                }
                //寻找到一个k所在的值，知道小于等于目标值，大于目标值，k向前移动
                while (j<k&&nums[j]+nums[k]>target) {
                    k--;
                }
                if (j==k) {
                    break;
                }
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
