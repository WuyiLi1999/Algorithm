package com.leetcode.LinkedList;

//86:分隔链表中的元素
public class Test86_partition {
    public ListNode partition(ListNode head, int x){
        if (head==null){
            return null;
        }
        //小于指定元素的链表的虚拟头结点
        ListNode leftNode=new ListNode(-1);
        ListNode left=leftNode;
        //大于等于指定元素的链表的虚拟头结点
        ListNode rightNode=new ListNode(-1);
        ListNode right=rightNode;
        //循环遍历当前节点
        while (head!=null){
            //如果当前节点的值小于指定元素，当前节点连接到左节点上，否则连接到右节点上
            if (head.val<x){
                left.next=head;
                left=left.next;
            }else {
                right.next=head;
                right=right.next;
            }
            head=head.next;
        }
        //右面节点的末尾指向null
        right.next=null;
        //左节点的next指向大于指定元素的头结点
        left.next=rightNode.next;
        return leftNode.next;
    }
}

