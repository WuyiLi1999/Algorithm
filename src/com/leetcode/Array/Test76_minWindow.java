package com.leetcode.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//76：最小覆盖子串
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
public class Test76_minWindow {

    public String minWindow(String s, String t) {
        //使用两个Map集合来记录字符串中字符的出现频率
        Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> tMap=new HashMap<>();
        int sLen=s.length(),tLen=t.length();
        if (sLen<tLen) {
            return "";
        }
        //初始化子串对应的tMap
        for (int i = 0; i < tLen; i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        //滑动窗口的初始值
        int left=0,right=-1;
        int minLength=s.length()+1,start=-1,end=-1;//记录s中覆盖的最小子串的长度，s子串的起始位置和终止位置
        String result="";
        //来移动滑动窗口的左右边界来进行寻找最小覆盖子串
        while (right<sLen){
            right++;
            //如果当前窗口的右边界的元素是子串中的元素，添加到滑动窗口中，并更新sMap的值
            if (right<sLen&&tMap.containsKey(s.charAt(right))){
                sMap.put(s.charAt(right),sMap.getOrDefault(s.charAt(right),0)+1);
            }
            //缩小滑动窗口的左边界来寻找最小的覆盖子串
            while (left<=right&&check(sMap,tMap)){

                if (right-left+1<minLength){//判断当前子串是否是最小的子串，是的话，更新最小子串的长度并更新子串的起始值
                    minLength=right-left+1;
                    start=left;
                    end=start+minLength;
                }
                //缩小滑动窗口左边界，如果左边界的元素在子串中，就移除并更新sMap的值，否则的话直接移除
                if (tMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left),sMap.getOrDefault(s.charAt(left),0)-1);
                }
                left++;
                //记录最小覆盖子串
                result=start==-1?"":s.substring(start,end);
            }
        }
        return result;
    }
    //判断滑动窗口中的元素是否包含子串中的所有元素元素
    private boolean check(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        Set<Character> keySet = tMap.keySet();
        //遍历子串中的所有元素，只要滑动窗口中的元素频率小于子串中的频率，就不是全部包含，返回false，否则的话返回true
        for (Character key:keySet) {
            int value=tMap.get(key);
            if (sMap.getOrDefault(key,0)<value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Test76_minWindow().minWindow("ADOBECODEBANC","ABC"));
    }
}
