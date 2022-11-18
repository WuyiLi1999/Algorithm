package com.leetcode.Array;

//27:移除数组中指定元素的值，返回移除后数组的新长度
//给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
//不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
public class Test27_removeElement {
    //时间复杂度O(n) 空间复杂度O(1)
    public int removeElement(int[] nums, int val) {
        int k=0;//k中记录的是nums[k]=val的数组元素的索引位置
        for (int i = 0; i < nums.length; i++) {//遍历数组的所有元素
            if (nums[i]!=val){//找到一个不等于val的值，与等于val的数组元素进行交换
                if (i!=k){//如果当前两个位置不相等，交换k和i位置的元素
                    int temp=nums[i];
                    nums[i]=nums[k];
                    nums[k++]=temp;
                }else //相等的话 证明当前k位置的值 不等于val，k++继续寻找等于val的值
                    k++;
            }
        }
        return k;
    }
}
