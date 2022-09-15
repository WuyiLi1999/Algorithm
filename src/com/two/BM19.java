package com.two;

//BM19:寻找峰值-返回峰值的下标
public class BM19 {
    public int findPeakElement (int[] nums) {
        // write code here

        int left=0,right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1])
                left=mid+1;
            else
                right=mid;
        }
        return right;
    }
}
