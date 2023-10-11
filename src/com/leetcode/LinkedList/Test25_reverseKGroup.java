package com.leetcode.LinkedList;
//25:K个一组翻转链表
public class Test25_reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k){
        if (head==null){
            return null;
        }
        //虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        //保存待翻转节点的前一个节点（之前都是翻转好的）
        ListNode preNode=dummyHead;
        //保存每一次翻转的节点的末尾（下一次要翻转的头结点）
        ListNode endNode=dummyHead;
        while (endNode.next!=null){
            //找到待翻转链表的末尾结点（k个）
            for (int i = 0; endNode!=null&&i < k; i++) {
                endNode = endNode.next;
            }
            //如果不足k个就不翻转
            if (endNode==null){
                break;
            }
            //记录要翻转的k个长度的链表
            ///保存当前要反转的长度为k的链表的头部
            ListNode reverseNode=preNode.next;
            //记录下一次要翻转的链表的头结点
            ListNode next=endNode.next;
            endNode.next=null;
            //翻转链表，并将翻转后的链表指向已经翻转好的节点的next指针
            preNode.next=reverse(reverseNode);
            //翻转之前的链表的头部（现在是链表的末尾）的next指向接下来要翻转的节点
            reverseNode.next=next;
            //接下来要翻转的节点的前一个节点指向翻转之前的链表的头部（现在是链表的末尾）
            preNode=reverseNode;
            //接下俩要翻转的链表的前一个节点为翻转之前的链表的头部（现在是链表的末尾）
            endNode=preNode;
        }
        return dummyHead.next;
    }
    private ListNode reverse(ListNode curNode) {
        //已经反转的链表的头节点（初始为null）
        ListNode pre=null;
        //要反转的当前节点
        ListNode cur=curNode;
        while (cur!=null){
            //保存接下俩要翻转的链表头结点
            ListNode node=cur.next;
            cur.next=pre;
            pre=cur;
            cur=node;
        }
        return pre;
    }
}
