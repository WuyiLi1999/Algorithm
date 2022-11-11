package com.leetcode.LookupTable;

import java.util.*;

//451:根据字符出现的频率进行排序输出
//给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
public class Test451_frequencySort {
    //使用HashMap+优先队列--HashMap来保存字符出现的频率，优先队列进行排序（小根堆）
    //时间复杂度O(nlogn) 空间复杂度O(n)
    public String frequencySort(String s) {
        //1、计算字符串中每一个字符出现的频率
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i)))
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            else
                hashMap.put(s.charAt(i),1);
        }
        //2、将HashMap中的元素添加到优先队列中进行排序（小根堆）
        PriorityQueue<Freq> priorityQueue=new PriorityQueue<>();
        for (Character key: hashMap.keySet()) {
            priorityQueue.add(new Freq(key,hashMap.get(key)));
        }
        //3、根据元素频率进行排序输出
        char [] newStr=new char[s.length()];
        for (int i = newStr.length-1; i >=0 ; ) {
            Freq freq=priorityQueue.poll();
            for (int j = 0; j < freq.freq; j++) {
                newStr[i--]= freq.c;
            }
        }
        return new String(newStr);
    }
    class Freq implements Comparable<Freq>{
        private char c;
        private int freq;
        public Freq(char c, int freq) {
            this.c=c;
            this.freq=freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq>o.freq)
                return 1;
            else if (this.freq<o.freq)
                return -1;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        String s="AAAACCCCCBBB";
        System.out.println(new Test451_frequencySort().frequencySort(s));
    }
}
