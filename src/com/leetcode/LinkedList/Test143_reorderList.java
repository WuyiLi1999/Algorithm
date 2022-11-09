package com.leetcode.LinkedList;

//143:链表重排列
//L0 → L1 → … → Ln - 1 → Ln  重新排列为   L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

public class Test143_reorderList {
    //方法一：寻找链表中点 + 链表逆序 + 合并链表 时间复杂度O(n)，空间复杂度O(1)
    public void reorderList(ListNode head) {
        //寻找链表中点（快慢指针）
        if(head==null)
            return;
        ListNode midNode=middleNode(head);
        //分割出两个子链表
        ListNode l1=head;
        ListNode l2=midNode.next;
        midNode.next=null;
        //对链表中点之后的子链表进行逆序
        l2=reverseList(l2);
        //合并连个子链表
        mergeList(l1,l2);
    }
    //寻找链表中点
    private ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if (fast.next!=null)
                fast=fast.next;
        }
        return slow;
    }
    //链表反转
    private ListNode reverseList(ListNode l2) {
        ListNode preNode=null;
        ListNode curNode=l2;
        ListNode next=null;
        while (curNode!=null){
            next=curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=next;
        }
        return preNode;
    }
    //链表合并
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_temp=l1;
        ListNode l2_temp=l2;
        //每一次开始都是从新的l1
        while (l1!=null&&l2!=null){
            //保存接下来的两个节点
            l1_temp=l1.next;
            l2_temp=l2.next;
            //合并两个链表（当前l1.next 等于当前l2）
            l1.next=l2;
            l1=l1_temp;//更新l1的值
            //当前l2.next等于新的l1
            l2.next=l1;
            l2=l2_temp;
        }
    }
}
