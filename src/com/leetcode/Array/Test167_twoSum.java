package com.leetcode.Array;

//167:两数之和，输入的是一个有序数组（结果值唯一）
//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数
public class Test167_twoSum {
    //双指针的思想时间复杂度O(logn)，空间复杂度O(1)
    public int[] twoSum(int[] numbers, int target) {
        //定义两个指针，分别指向第一个元素位置和最后一个元素的位置
        int left=1,right= numbers.length;
        while (left<right){
            //如果两位置中的值之和等于目标值target，就返回该两位置
            if(numbers[left-1]+numbers[right-1]==target){
                return new int[]{left,right};
            }else if(numbers[left-1]+numbers[right-1]>=target){
                right--;
            }else {
                left++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int [] nums={2,7,11,15};
        int [] result=new Test167_twoSum().twoSum(nums,9);
        System.out.println(result[0]+"\t"+result[1]);
    }
}
