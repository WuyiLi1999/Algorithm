package com.leetcode.Array;

//88:合并两个有序数组
//给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
public class Test88_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从后往前遍历数组
        int i=m,j=n,k=m+n;
        while (i>0&&j>0){
            //如果nums1的末尾非0元素小于nums2的末尾元素，将nums2[0...j)中的最大值添加到nums1的--k位置
            if (nums1[i-1]<nums2[j-1]){
                nums1[--k]=nums2[--j];
            }else{//否则的话，将nums1[0...i)中的最大值添加到nums1的--k位置
                nums1[--k]=nums1[--i];
            }
        }
        //如果nums2数组未遍历完成（nums2中的[0...j-1]中的元素都小于数组nums1[k]），所以将nums2中的元素依次拷贝到nums1[0...k-1]中
        if (j!=0){
            for (int l = j-1; l >= 0; l--) {
                nums1[--k]=nums2[l];
            }
        }
    }

    public static void main(String[] args) {
        int [] nums1={1,3,5,0,0,0};
        int [] nums2={2,4,6};
        new Test88_merge().merge(nums1,3,nums2,3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+"\t");
        }
    }
}
