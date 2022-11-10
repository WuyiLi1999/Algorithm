package com.leetcode.LookupTable;

import java.util.HashMap;
import java.util.Map;

//290:单词规律---给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
public class Test290_wordPattern {
    //时间复杂度O(n)，空间复杂度O(n)
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        //Map中的put函数  如果键值已存在更新value值并返回之前的value值，如果键值不存在插入成功并返回null
        for (Integer i = 0; i < words.length; i++) {
            //Integer i =0 ---提前完成了自动装箱，所以循环体内map两次put操作存的value都是同一个Integer对象
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
