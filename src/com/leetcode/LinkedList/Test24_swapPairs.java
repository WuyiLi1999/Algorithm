package com.leetcode.LinkedList;

//24:两两交换链表中的节点
public class Test24_swapPairs {
    //
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        //建立一个虚拟头结点
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode curNode=preHead;
        //设立一个新的节点对curNode节点操作就是对preHead点操作
        // 在操作的过程中curNode的节点位置在变化，preHead一直指向链表的头结点）
        while (curNode.next!=null&&curNode.next.next!=null){
            //记录三个节点值（要交换的两个节点和下一个要交换的节点）
            ListNode node1=curNode.next;
            ListNode node2=node1.next;
            ListNode next=node2.next;
            //节点交换
            node1.next=next;
            node2.next=node1;
            curNode.next=node2;
            //curNode需要跳到第二个节点位置：在原来的时候curNode需要指向node2节点的，由于node1node2位置交换了
            curNode=node1;

        }
        return preHead.next;
    }
}
