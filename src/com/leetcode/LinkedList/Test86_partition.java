package com.leetcode.LinkedList;

//86:分隔链表中的元素
public class Test86_partition {
    public ListNode partition(ListNode head, int x) {
        if (head==null)
            return null;
        ListNode leftNode=new ListNode(-1);
        ListNode left=leftNode;
        ListNode rightNode=new ListNode(-1);
        ListNode right=rightNode;
        while (head!=null){
            if (head.val<x){
                left.next=head;
                left=left.next;
            }else {
                right.next=head;
                right=right.next;
            }
        }
        right.next=null;
        left.next=rightNode.next;
        return leftNode.next;
    }
}
