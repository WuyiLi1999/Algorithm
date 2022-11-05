package com.leetcode.LinkedList;

//203:移除链表中指定值的元素
public class Test203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode curNode=preHead;
        while (curNode.next!=null){
            if (curNode.next.val==val) {
                ListNode delNode = curNode.next;
                curNode.next = delNode.next;
                delNode.next = null;
            }
            else
                curNode=curNode.next;
        }
        return preHead.next;
    }
}
