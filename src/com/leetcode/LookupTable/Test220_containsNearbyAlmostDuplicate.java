package com.leetcode.LookupTable;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

//220:存在重复元素三
//给你一个整数数组 nums 和两个整数k 和 t 。
// 请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
public class Test220_containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> treeSet=new TreeSet<>();
        for (int i=0;i<nums.length;i++){
            Long number=treeSet.ceiling((long) nums[i]-(long)valueDiff);
            if(number!=null&&number<=(long)nums[i]+(long)valueDiff){
                return true;
            }
            treeSet.add((long) nums[i]);
            if(treeSet.size()==indexDiff+1)
                treeSet.remove((long)nums[i-indexDiff]);
        }
        return  false;
    }

    public static void main(String[] args) {
        int [] nums={1,5,9,1,5,9};
        System.out.println(new Test220_containsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums,2,3)?1:0);
    }
}
