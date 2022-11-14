package com.leetcode.LookupTable;

import java.util.HashMap;
import java.util.Map;

//454：四数相加二
/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */


public class Test454_fourSumCount {
    //时间复杂度O(n^2) 空间复杂度O(n^2)
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (hashMap.containsKey(nums1[i]+nums2[j]))
                    hashMap.put(nums1[i]+nums2[j],hashMap.get(nums1[i]+nums2[j])+1);
                else
                    hashMap.put(nums1[i]+nums2[j],1);
            }
        }
        int result=0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (hashMap.containsKey(0-nums3[i]-nums4[j]))
                    result+=hashMap.get(0-nums3[i]-nums4[j]);
            }
        }
        return result;
    }
}
