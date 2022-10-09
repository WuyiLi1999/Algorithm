package com.nowcoder.nine;

import java.util.HashMap;

/**BM92:最长无重复子数组
 *给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 */
public class BM92 {
    public int maxLength (int[] arr) {
        // write code here
        if (arr.length==0)
            return 0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int left=0,right=0;
        int length=0;
        for (; right < arr.length; right++) {
            if (hashMap.containsKey(arr[right]))
                left=Math.max(left,hashMap.get(arr[right])+1);
            hashMap.put(arr[right],right);
            length=Math.max(length,right-left+1);
        }
        return length;
    }

    public static void main(String[] args) {
        int[] arr={2,2,3,4,3,5,6,7};
        System.out.println("length:"+new BM92().maxLength(arr));
    }
}
