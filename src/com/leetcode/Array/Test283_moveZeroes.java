package com.leetcode.Array;
//283:移动零
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
public class Test283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int k=0;//当前0的位置 nums[0...k)中为非0元素，nums[k...i]中元素为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                if (i != k) {
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k++] = temp;
                } else
                    k++;
        }
    }
}
