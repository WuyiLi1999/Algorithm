package com.leetcode.LinkedList;

//19：删除链表中倒数第N个节点--虚拟头结点+双指针（快慢指针）
public class Test19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //当前链表为null，或者n小于1（不符合输入）
        if (head==null||n<1)
            return head;
        //虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        //定义两个快慢指针
        ListNode slow=dummyHead;
        ListNode fast=dummyHead;
        //移动快指针，确保快慢指针之间相差n个节点
        int i=0;
        for (i = 0; i < n && fast!=null; i++)
            fast=fast.next;
        if (i!=n)//n超过了链表的节点个数--无法删除，返回原链表
            return head;
        //同时移动快慢指针，找到指向倒数第N个节点的前一个节点--保存在slow
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;
        return dummyHead.next;
    }
}
