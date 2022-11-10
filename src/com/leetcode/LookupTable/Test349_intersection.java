package com.leetcode.LookupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//349:两个数组的交集--保证输出结果唯一，存在重复元素只输出一个  查找表之set
public class Test349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        //保证元素唯一使用Set集合存储
        HashSet<Integer>  hashSet=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])){
                list.add(nums2[i]);
                hashSet.remove(nums2[i]);
            }
        }
        int [] num=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            num[i]=list.get(i);
        }
        return num;
    }
}
