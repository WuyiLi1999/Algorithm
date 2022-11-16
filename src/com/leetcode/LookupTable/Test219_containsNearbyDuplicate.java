package com.leetcode.LookupTable;

import java.util.HashSet;

//219:存在重复元素——滑动窗口
public class Test219_containsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //用来保存滑动窗口[i...i+k]中的元素
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果哈希表中元素的个数大于指定的K的时候，将下标 i−k−1 处的元素被移出滑动窗口
            if (hashSet.size()>k){
                hashSet.remove(nums[i-k-1]);
            }
            //判断新的元素是否在滑动窗口中，在证明在哈希集合中则在同一个滑动窗口中有重复元素返回true，
            // 否则将当前元素添加进滑动窗口中，作为滑动窗口最后一个位置的元素
            if (hashSet.contains(nums[i]))
                return true;
            else
                hashSet.add(nums[i]);
        }
        return false;
    }
}
