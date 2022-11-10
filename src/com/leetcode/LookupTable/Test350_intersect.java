package com.leetcode.LookupTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//350：两数组的交集--输出结果可以包含重复元素
public class Test350_intersect {
    //可以包含重复元素，使用Map集合来存储元素出现的次数
    //时间复杂度O(n)，空间复杂度O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (hashMap.containsKey(nums1[i]))
                hashMap.put(nums1[i],hashMap.get(nums1[i])+1);
            else
                hashMap.put(nums1[i],1);
        }
        List<Integer> list=new ArrayList();
        for (int i = 0; i < nums2.length; i++) {
            if (hashMap.containsKey(nums2[i])&&hashMap.get(nums2[i])>0){
                list.add(nums2[i]);
                hashMap.put(nums2[i],hashMap.get(nums2[i])-1);
            }
        }
        int [] num=new int[list.size()];
        for (int i = 0; i < num.length; i++) {
            num[i]=list.get(i);
        }
        return num;
    }
}
