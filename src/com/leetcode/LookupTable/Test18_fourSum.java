package com.leetcode.LookupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//18：四数之和
/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足
 * 下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复
 */
public class Test18_fourSum {
    //时间复杂度O(n^3) 空间复杂度O(logn)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists=new ArrayList<>();
        if(nums.length<4||nums==null)
            return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i>0&&nums[i]==nums[i-1])
                continue;
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j>i+1&&nums[j]==nums[j-1])
                    continue;
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }

                int m=j+1;
                int n=nums.length-1;

                while (m<n){
                    long sum=nums[i]+nums[j]+nums[m]+nums[n];
                    if (sum==target){
                        lists.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        while (m<n&&nums[m+1]==nums[m])
                            m++;
                        m++;
                        while (m<n&&nums[n-1]==nums[n])
                            n--;
                        n--;
                    }else if(sum<target){
                        m++;
                    }else {
                        n--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int []  nums={0,0,0,-1000000000,-1000000000,-1000000000,-1000000000};

        List<List<Integer>>  result=new Test18_fourSum().fourSum(nums,-1000000000);
        if (result==null||result.size()==0)
            System.out.println("NULL");
        for (int i = 0; i < result .size(); i++) {
            List<Integer> list=result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j)+"  ");
            }
            System.out.println();
        }
    }
}
