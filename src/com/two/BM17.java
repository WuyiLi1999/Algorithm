package com.two;
//BM17:二分查找数组中目标元素的下标
public class BM17 {

    public int search (int[] nums, int target) {
        // write code here
        //数组为null，直接返回-1
        if (nums.length==0)
            return -1;
        //定义开始时的左面和右面的索引位置
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        while(left<right){
            if(nums[mid]==target)//如果找到，返回当前的索引位置
                return mid;
            else if(nums[mid]<target)//如果target大于中间元素，则在中间位置往右寻找
                left=mid+1;
            else//如果target小于中间元素，则在中间位置往左寻找
                right=mid-1;
        }
        return -1;
    }
}
