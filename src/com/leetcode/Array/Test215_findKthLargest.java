package com.leetcode.Array;

import java.util.Random;

//215:数组中第K个最大元素，时间复杂度为O(n)
public class Test215_findKthLargest {
    //基于快速排序
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }

    private int quickSelect(int[] nums, int left, int right, int index) {
        int q=randomPartition(nums,left,right);
        if (q==index)
            return nums[q];
        else
            return q>index ? quickSelect(nums,left,q-1,index):quickSelect(nums,q+1,right,index);
    }

    private int randomPartition(int[] nums, int left, int right) {
        int p= new Random().nextInt(right-left+1)+left;
        swap(nums,left,p);
        return partition(nums,left,right);
    }

    private int partition(int[] nums, int left, int right) {
        int j=left-1,num=nums[right];
        for (int i = left; i < right; i++) {
            if (nums[i]<=num){
                swap(nums,++j,i);
            }
        }
        swap(nums,j+1,right);
        return j+1;
    }

    private void swap(int[] nums, int left, int p) {
        int temp=nums[left];
        nums[left]=nums[p];
        nums[p]=temp;
    }

}
