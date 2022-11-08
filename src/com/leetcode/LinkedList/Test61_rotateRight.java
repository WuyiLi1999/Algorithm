package com.leetcode.LinkedList;

//61:链表旋转--双指针
public class Test61_rotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||k<=0)
            return head;
        //定义两个指针--快慢指针
        ListNode slow=head;
        ListNode fast=head;
        //计算链表的长度
        int size=0;
        while (slow!=null){
            size++;
            slow=slow.next;
        }
        slow=head;
        //防止K超过链表长度
        k=k%size;
        if (k==0)//不需要旋转
            return head;
        //先移动快指针，使得快慢指针之间相差K个元素
        for (int i = 0; i < k ; i++) {
            fast = fast.next;
        }
        //找到旋转后新的头结点的前一个节点--保存在slow中
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        fast.next=head;//链表的末尾节点为头结点相连--形成一个环
        head=slow.next;//旋转后新的链表头结点
        slow.next=null;//断开环
        return head;
    }
}
