package com.five;

import java.util.HashSet;
import java.util.Iterator;

/**BM51：数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 输出时按非降序排列。
 */
public class BM52 {
    //结合题意使用HashSet来进行存储
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        if (array.length<2)
            return null;
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i<array.length;i++){
            //只要当前元素在Set集合汇总存在，就删除；否则就添加到Set集合中
            if (hashSet.contains(array[i]))
                hashSet.remove(array[i]);
            else
                hashSet.add(array[i]);
        }
        //迭代遍历Set集合将元素保存在数组中
        int [] num=new int[hashSet.size()];
        int i=0;
        for (Iterator<Integer> it = hashSet.iterator(); it.hasNext(); ) {
            num[i++]=it.next();
        }
        return num;
    }
}
