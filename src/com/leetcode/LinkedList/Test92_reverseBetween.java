package com.leetcode.LinkedList;

import javax.jnlp.ClipboardService;

//92：反转指定区间的链表元素
public class Test92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null) {
            return head;
        }
        //虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        //要开始反转的节点的前一个节点
        ListNode preNode=dummyHead;
        //找到要反转的节点的前一个节点
        for (int i = 0; i < left-1; i++) {
            preNode=preNode.next;
        }

        //切出一个子链表（要反转的链表）
        ListNode leftNode=preNode.next;
        ListNode rightNode=leftNode;
        for (int i = 0; i < right-left; i++) {
            rightNode=rightNode.next;
        }
        //断开链表（剩余未反转链表的起始节点）
        ListNode node=rightNode.next;
        rightNode.next=null;
        preNode.next=null;
        //子链表反转
        reverse(leftNode);
        //重新链接，开始反转节点的前一个节点的next指向翻转链表的头结点（即翻转子链表的尾），
        //          翻转之后链表的尾（即翻转之前的头）的next指向剩下未反转的链表
        preNode.next=rightNode;
        leftNode.next=node;

        return dummyHead.next;
    }
    //反转链表中元素的指向顺序
    private void reverse(ListNode leftNode) {
        //反转之后的链表的头结点，初始为null
        ListNode pre=null;
        //要反转的当前节点
        ListNode cur=leftNode;
        //要反转的下一个节点
        ListNode next=null;
        //循环遍历，直到要反转的节点为null
        while (cur!=null){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
    }
}
