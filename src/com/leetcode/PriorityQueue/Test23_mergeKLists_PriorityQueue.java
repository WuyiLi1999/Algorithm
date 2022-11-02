package com.leetcode.PriorityQueue;

import java.util.PriorityQueue;

public class Test23_mergeKLists_PriorityQueue {
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
        PriorityQueue<Status> priorityQueue=new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null)
                priorityQueue.add(new Status(lists[i].val,lists[i]));
        }
        ListNode head=new ListNode(0);
        ListNode cur=head;
        while (!priorityQueue.isEmpty()){
            Status status=priorityQueue.poll();
            cur.next=status.curNode;
            cur=cur.next;
            if (status.curNode.next!=null)
                priorityQueue.add(new Status(status.curNode.next.val,status.curNode.next));
        }
        return head.next;
    }
}

