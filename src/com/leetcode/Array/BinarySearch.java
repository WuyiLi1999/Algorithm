package com.leetcode.Array;

//二分查找法
public class BinarySearch {
    //从有序数组的前n个元素中寻找目标元素target所在的索引位置，如果不存在返回-1
    public int binarySearch(int [] nums,int n,int target){
        int left=0;
        int right=n-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums=new int[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums[i]=i;
        }
        System.out.println(new BinarySearch().binarySearch(nums,nums.length,-1));
    }
}
