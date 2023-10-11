package com.leetcode.LinkedList;
//82:删除排序链表中的重复元素（虚拟头结点）
public class Test82_deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head){
        if (head==null){
            return null;
        }
        //虚拟头结点（防止头结点是重复元素，删除头结点之后导致头结点丢失）
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode curNode=dummyHead;
        //遍历当前节点（当前节点的next和当前节点的next的next不为null的时候）
        while (curNode.next!=null&&curNode.next.next!=null){
            //如果当前节点的next和当前节点的next的next节点的相等——需要删除接下来节点值与他相等的节点
            if (curNode.next.val==curNode.next.next.val){
                int val=curNode.next.val;
                while (curNode.next!=null&&curNode.next.val==val){
                    curNode.next=curNode.next.next;
                }
            }else {//遍历下一个节点
                curNode=curNode.next;
            }
        }
        return dummyHead.next;
    }

}
