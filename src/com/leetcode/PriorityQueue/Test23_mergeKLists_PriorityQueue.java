package com.leetcode.PriorityQueue;

import java.util.PriorityQueue;

//23:合并K个升序链表---使用优先队列来进行合并
public class Test23_mergeKLists_PriorityQueue {
    //内部类--保存当前节点和当前节点中的值（用来排序）
    class Status implements Comparable<Status>{
        private int val;
        private ListNode curNode;
        public Status(int val, ListNode curNode){
            this.val=val;
            this.curNode=curNode;
        }
        @Override
        public int compareTo(Status o) {
            return this.curNode.val-o.curNode.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0||lists==null)
            return null;
        if (lists.length==1)
            return lists[0];
        //使用优先队列来保存数据，优先队列中保存K个链表信息
        PriorityQueue<Status> priorityQueue=new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null)
                priorityQueue.add(new Status(lists[i].val,lists[i]));
        }
        //定义初始链表头结点（保存合并后的链表信息）
        ListNode head=new ListNode(0);
        ListNode cur=head;

        while (!priorityQueue.isEmpty()){
            //1.出队--移除优先队列中队首元素（Node节点val值最小的一个）
            Status status=priorityQueue.poll();
            //2.节点链接到当前节点的末尾，当前节点等于该节点
            cur.next=status.curNode;
            cur=cur.next;
            //如果出队的节点存在下一个节点信息，将下一个节点信息添加到优先队列中
            if (status.curNode.next!=null)
                priorityQueue.add(new Status(status.curNode.next.val,status.curNode.next));
        }
        return head.next;
    }
}

