package com.leetcode.Array;

//26：删除有序数组中的重复项
//给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
// 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
public class Test26_removeDuplicates {
    //时间复杂度O(n) 空间复杂度O(1)
    public int removeDuplicates(int[] nums) {
        int k=0;//记录当前不重复元素的位置nums[0...k]中是已经去重好的数组元素
        for (int i = 1; i < nums.length; i++) {
            //如果当前元素与nums[k](排好序的最后一个元素)不等，证明该元素是不重复元素，添加进去重后的末尾
            if (k!=i&&nums[k]!=nums[i]){
                nums[++k]=nums[i];
            }
        }
        return k+1;
    }
}
