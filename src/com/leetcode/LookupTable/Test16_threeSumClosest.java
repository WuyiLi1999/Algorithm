package com.leetcode.LookupTable;

import java.util.Arrays;

//16:最接近的三数之和
public class Test16_threeSumClosest {
    //时间复杂度O(n^2)，空间复杂度O(logn)
    public int threeSumClosest(int[] nums, int target) {
        int result=Integer.MAX_VALUE;
        if(nums==null||nums.length<3)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j=i+1;
            int k= nums.length-1;
            while (j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if (sum==target)
                    return target;
                if(Math.abs(sum-target)<Math.abs(result-target))
                    result=sum;
                if (sum>target){
                    while (j<k&&nums[k]==nums[k-1])
                        k--;
                    k--;
                }else {
                    while (j<k&&nums[j]==nums[j+1])
                        j++;
                    j++;
                }
            }
        }
        return result;
    }
}
