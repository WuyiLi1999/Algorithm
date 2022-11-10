package com.leetcode.LinkedList;

//234:判断链表是否为回文链表--快慢指针
public class Test234_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        //找到链表中点
        ListNode midNode=middleNode(head);
        //将原来的链表切分为两个子链表
        ListNode l1=head;
        ListNode l2=midNode.next;
        //子链表反转
        l2=reverseList(l2);
        ListNode pre=l2;
        //判断链表是否回文
        boolean result=true;
        while (result&&l2!=null){
            if (l1.val!= l2.val)
                result=false;
            else {
                l1=l1.next;
                l2=l2.next;
            }
        }
        //还原链表并返回结果
        reverseList(pre);
        return result;
    }
    //反转链表
    private ListNode reverseList(ListNode head) {
        ListNode preNode =null;
        ListNode curNode=head;
        ListNode next=null;
        while (curNode!=null){
            next=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=next;
        }
        return preNode;
    }
    //寻找链表中点
    private ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
