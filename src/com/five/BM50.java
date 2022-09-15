package com.five;

import java.util.HashMap;

/**
 * BM50:两数之和--数组、哈希
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 */
public class BM50 {
    //基于HashMap进行求解--时间复杂度O(n)空间复杂度O(n)
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        if (numbers.length < 2)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i])+1,i + 1};
            } else
                map.put(numbers[i], i);
        }
        return null;
    }
    //暴力求解--时间复杂度O(n^2)空间复杂度O(1)
    public int[] twoSum_1 (int[] numbers, int target) {
        // write code here
        if (numbers.length<2)
            return null;
        int [] num=new int[2];
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]>target)
                continue;
            for (int j=i+1;j<numbers.length;j++){
                if (numbers[i]+numbers[j]==target){
                    num[0]=i+1;
                    num[1]=j+1;
                    return num;
                }
            }
        }
        return null;
    }
}
