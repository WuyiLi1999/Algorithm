package com.nowcoder.four;

import java.util.ArrayDeque;
import java.util.ArrayList;
//BM45:给定一个长度为 n 的数组 nums 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值。
public class BM45 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list=new ArrayList<>();
        if (num.length<size)
            return null;
        //双边队列中保存的是最大值元素索引位置和该位置之后比他小的元素的索引位置（首元素是最大值的索引）
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        //先遍历第一个窗口[0,size-1]，如果即将进入队列的下标的值大于队列后方的值，依次将小于的值拿出来去掉，再加入，保证队列是递增序。
        for (int i=0;i<size;i++){
            while(!deque.isEmpty()&&num[deque.peekLast()]<num[i])
                deque.pollLast();
            deque.add(i);
        }
        for (int i = size; i < num.length; i++) {
            list.add(num[deque.peekFirst()]);
            //判断当前队列中的最大值的索引位置是否在下一个滑动窗口的范围中[i-size+1...i]
            //如果不在，就将队列中的首元素移除
            while(!deque.isEmpty()&&deque.peekFirst()<i-size+1)
                deque.pollFirst();
            //判断新添加的元素和队列中末尾元素的大小--如果大于 依次将队尾小于的值拿出来去掉，再加入，保证队列是递增序。
            while(!deque.isEmpty()&&num[deque.peekLast()]<num[i])
                deque.pollLast();
            //将当前元素加入队列的末尾--保证队列中的索引位置的元素是逆序的
            deque.add(i);
        }
        list.add(num[deque.pollFirst()]);
        return list;
    }
}
