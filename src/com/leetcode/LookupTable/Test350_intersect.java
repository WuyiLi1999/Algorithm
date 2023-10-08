package com.leetcode.LookupTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//350：两数组的交集--输出结果可以包含重复元素
public class Test350_intersect {
    //可以包含重复元素，使用Map集合来存储元素出现的次数
    //时间复杂度O(n)，空间复杂度O(n)
    public int[] intersect(int[] nums1, int[] nums2){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])&&map.get(nums2[i])>0){
                list.add(nums2[i]);
                map.put(nums2[i],map.getOrDefault(nums2[i],0)-1);
            }
        }
        int [] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]= list.get(i);
        }
        return result;
    }
}
