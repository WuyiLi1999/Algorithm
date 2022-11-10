package com.leetcode.LookupTable;

//242:有效的字母异位词（若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词）
public class Test242_isAnagram {
    //时间复杂度O(n)，空间复杂度O(S)--S=26
    public boolean isAnagram(String s, String t) {
        //判断两个字符串的长度是否一样
        if (s.length()!=t.length())
            return false;
        //记录每一个单词对应的位置出现的次数'a'--0，依次递增
        int [] nums=new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            nums[t.charAt(i)-'a']--;
            //如果table[i]<0 -- 说明 t 包含一个不在 s 中的额外字符
            if (nums[t.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }
}
