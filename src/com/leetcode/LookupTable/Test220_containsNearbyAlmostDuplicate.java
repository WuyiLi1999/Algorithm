package com.leetcode.LookupTable;

import java.util.TreeSet;

//220:存在重复元素三
//给你一个整数数组 nums 和两个整数k 和 t 。
// 请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
public class Test220_containsNearbyAlmostDuplicate {
    //对于序列中每一个元素 x左侧的至多 k个元素，如果这 k个元素中存在一个元素落在区间[x−t,x+t] 中，我们就找到了一对符合条件的元素
    //时间复杂度O(nlogn) 空间复杂度O(n)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        //使用有序的treeSet集合来存储，在查找的时候时间复杂度为O(logn)
        TreeSet<Long> treeSet=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果当前集合中的元素个数等于滑动窗口中最多能存放的元素个数--移除滑动窗口的第一个元素
            if (treeSet.size()==indexDiff+1) {
                treeSet.remove((long)nums[i-indexDiff-1]);
            }
            //判断当前元素在滑动窗口中能否找到一个元素满足大于等于 num[i]-valueDiff  如果有就返回符合的一个最小值，没有返回null
            Long num=treeSet.floor((long) nums[i]+(long)valueDiff);
            //如果这个最小值存在并且小于等于num[i]+valueDiff --证明在滑动窗口中该元素是符合题意的
            if (num!=null&&num>=(long)nums[i]-(long) valueDiff) {
                return true;
            }
            treeSet.add((long)nums[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int [] nums={1,5,9,1,5,9};
        System.out.println(new Test220_containsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums,2,3)?1:0);
    }
}
