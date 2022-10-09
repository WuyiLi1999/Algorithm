package com.nowcoder.five;


import java.util.HashSet;

/**BM53:缺失的第一个正整数
 *给定一个未排序的整数数组nums，请你找出其中没有出现的最小的正整数
 * 进阶： 空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 */
public class BM53 {
    //时间复杂度O(n) 空间复杂度O(n)
    public int minNumberDisappeared (int[] nums) {
        // write code here
        //新建Hashset集合用来保存元素中出现的元素
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        //设置第一个正整数为1，循环遍历判断集合中是否包含该元素:包含就将当前值加一，否则的话返回当前值为足额是的第一个整数
        int  result=1;
        while (hashSet.contains(result)){
            result++;
        }
        return result;
    }
}
