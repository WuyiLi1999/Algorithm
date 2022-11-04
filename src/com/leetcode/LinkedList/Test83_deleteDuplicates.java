package com.leetcode.LinkedList;

//83:删除排序链表中的重复元素
public class Test83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        ListNode curNode=head;
        ListNode preNode=head;
        while (curNode!=null){
            if (preNode.val!=curNode.val){
                preNode.next=curNode;
                preNode=curNode;
            }
            curNode=curNode.next;
        }
        preNode.next=null;
        return head;
    }
    public ListNode deleteDuplicates_1(ListNode head) {
        if (head==null)
            return null;
        ListNode curNode=head;

        while (curNode!=null&&curNode.next!=null){
            if (curNode.val==curNode.next.val)
                curNode.next=curNode.next.next;
            else
                curNode=curNode.next;
        }
        return head;
    }
}
