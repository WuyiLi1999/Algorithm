package com.leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//438:找到字符串中都有的异位词
public class Test438_findAnagrams {
    //固定长度的滑动窗口来判断异位词，时间复杂度O(N)，空间复杂度O(M)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        //当字符串 s 的长度小于字符串 p 的长度时--不足以构建异位词，直接返回null
        if (s.length()<p.length())
            return list;
        int [] sCount=new int[26];
        int [] pCount=new int[26];
        //记录窗口[0,p.length()-1]中的每种字母出现的次数
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i)-'a']++;
            pCount[p.charAt(i)-'a']++;
        }
        //窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，则说明当前窗口为字符串 p 的异位词
        if (Arrays.equals(pCount,sCount))
            list.add(0);
        //依次遍历数组s，移动窗口，来判断s中的[i+1..i+p.length()]是否是p的异位词
        for (int i = 0; i < s.length()-p.length(); i++) {
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+p.length())-'a']++;
            if (Arrays.equals(sCount,pCount)){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list=new Test438_findAnagrams().findAnagrams("cbaebabacd","abc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
