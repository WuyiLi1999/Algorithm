package com.leetcode.LinkedList;

//206：链表反转
public class Test206_reverseList {
    //时间复杂度O(n)，空间复杂度O(1)
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode pre=null;//已经反转的链表的头节点（初始为null）
        ListNode cur=head;//要反转的当前节点
        ListNode next=null;//要反转的下一个节点
        while (cur!=null){//循环遍历，知道要反转的节点为null
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
