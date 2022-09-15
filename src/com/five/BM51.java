package com.five;

import java.util.HashMap;

/**
 * BM51:数组中次数超过一半的数字--数组、哈希
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class BM51 {
    //时间复杂度O(n)，空间复杂度O(n)
    public int MoreThanHalfNum_Solution(int [] array) {
        //如果当前数组为null，返回-1--表示不存在
        if (array.length==0)
            return -1;
        //定义一个HashMap存储以元素值为键，存在次数为值的键值对
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<array.length;i++){
            //如果当前键值存在--使该键对应的值+1；否则的话像map中添加以该元素为键，1为值
            if (map.containsKey(array[i]))
                map.put(array[i], map.get(array[i])+1);
            else
                map.put(array[i],1);
            //判断该元素值对应的value值是否大于数组长度的一半
            if (map.get(array[i])>array.length/2)
                return array[i];
        }
        return -1;
    }
}
