package com.leetcode.PriorityQueue;

import java.util.*;

//347:前K个高频元素
public class Test347_topKFrequent {
    //时间复杂度O(nlogk)，空间复杂度o(n)
    public int[] topKFrequent(int[] nums, int k){
        //Map用来维护所有的数字和其对应的频率的一个键值对
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        //使用Java中的优先队列来来统计出现频率前K的元素（小根堆）
        PriorityQueue<Freq> priorityQueue=new PriorityQueue<>();
        for (int key: map.keySet()) {
            if (priorityQueue.size()<k)//优先队列中不足K个的元素，直接添加该元素
                priorityQueue.add(new Freq(key,map.get(key)));
            //否则的判断当前元素的出现频率和优先队列中第一个元素的频率大小。大于就移除队首元素，然后添加当前元素，否则什么都不做
            else if (priorityQueue.peek().freq < map.get(key)){
                priorityQueue.remove();
                priorityQueue.add(new Freq(key,map.get(key)));
            }
        }
        //将出现频率最高的前K个元素添加到数组中并返回
        int [] num=new int[k];
        for (int i = 0; i < num.length; i++) {
            num[i]=priorityQueue.remove().num;
        }
        return num;
    }
    class Freq implements Comparable<Freq>{
        private int num;
        private int freq;
        Freq(int num,int freq){
            this.num=num;
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
        int [] nums={1,2,3,4,5,6,1,2,3,4,1,2,3};
        int [] num=new Test347_topKFrequent().topKFrequent(nums,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(num[i]);
        }
    }
}
