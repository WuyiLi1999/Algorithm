package com.leetcode.LookupTable;

import java.util.*;

//49:字母异位词分组
public class Test49_groupAnagrams {
    //方案一：计数
    //由于互为字母异位词的两个字符串包含的字母相同，
    // 因此两个字符串中的相同字母出现的次数一定是相同的，故可以将每个字母出现的次数使用字符串表示，作为哈希表的键。
    public List<List<String>> groupAnagrams(String[] strs) {
        //map中存储的是以字符串为键（字符和该字符出现的次数组成），所有的一样组成的字符串为值（存储在list集合中）
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        if(strs==null||strs.length==0)
            return new ArrayList<>(map.values());
        //遍历所有的字符串
        for (String str:strs) {
            int [] nums=new int[26];
            for (int i = 0; i < str.length(); i++) {
                nums[str.charAt(i)-'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer buffer=new StringBuffer();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]!=0){
                    buffer.append((char) i+'a');
                    buffer.append(nums[i]);
                }
            }
            String key=buffer.toString();
            List list=map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
    /**
     * 方案二：排序
     * 字母异位词的 字符串对应的字符数据排序之后是一样的字符串
     */
    //时间复杂度：O(nklogk)，其中n是 strs 中的字符串的数量,k是strs中的字符串的的最大长度;空间复杂度O(nk)

    public List<List<String>> groupAnagrams_sort(String[] strs) {
        //map中存储的是以排序好的字符串为键，所有的一样组成的字符串为值（存储在list集合中）
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        if(strs==null||strs.length==0)
            return new ArrayList<>(map.values());
        //遍历所有的字符串
        for (String str:strs) {
            char [] arr=str.toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            List list=map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
