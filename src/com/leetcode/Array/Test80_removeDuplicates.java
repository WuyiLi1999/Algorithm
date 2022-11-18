package com.leetcode.Array;

//80：删除有序数组中的重复项二
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
public class Test80_removeDuplicates {
    //时间复杂度O(n) 空间复杂度O(1)
    public int removeDuplicates(int[] nums) {
        int k=1;
        for (int i = 2; i < nums.length; i++) {
            if (!(nums[k]==nums[i]&&nums[k]==nums[k-1])){
                nums[++k]=nums[i];
            }
        }
        return k+1;
    }
}
