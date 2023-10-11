package com.leetcode.LinkedList;

//24:两两交换链表中的节点
public class Test24_swapPairs {

    public ListNode swapPairs(ListNode head){
        if (head==null){
            return null;
        }
        //建立一个虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode curNode=dummyHead;
        //循环遍历当前节点（当前节点的next与当前节点的next的next都不为null--两两一组交换位置）
        while (curNode.next!=null&&curNode.next.next!=null){
            //记录当前要交换的两个元素与接下来要判断的元素
            ListNode first=curNode.next;
            ListNode second=first.next;
            ListNode next= second.next;
            // 节点交换
            first.next=next;
            curNode.next=second;
            curNode.next.next=first;
            //curNode需要跳到第二个节点位置：在原来的时候curNode需要指向node2节点的，由于node1node2位置交换了
            curNode=first;
        }
        return dummyHead.next;
    }
}
