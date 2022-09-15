package com.four;

import java.util.PriorityQueue;

//BM47：寻找数组中第K大的元素--优先队列（小根堆）
public class BM47 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        //使用一个优先队列（小根堆）来进行维护，存放K个元素，优先队列总第一个元素就是第K大的元素
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(K);
        //遍历整个数组
        for (int i = 0; i < a.length; i++) {
            //当前优先队列元素小于K--添加元素
            if (priorityQueue.size()<K)
                priorityQueue.add(a[i]);
            else {
                //判断当前优先队列中首元素与当前元素的大小，如果小于，就将队列手元素出队，然后将当前元素入队
                if (priorityQueue.peek()<a[i]){
                    priorityQueue.poll();
                    priorityQueue.add(a[i]);
                }
            }
        }
        //返回当前队列的首元素
        return priorityQueue.isEmpty()?0:priorityQueue.peek();
    }
}
