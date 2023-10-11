package com.leetcode.LinkedList;

//83:删除排序链表中的重复元素
public class Test83_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return null;
        }
        //双指针（一个指向当前节点，一个指向与当前节点最近一次不相同的节点）
        ListNode curNode=head;
        //处理完成之后的节点头部
        ListNode preNode=head;
        //循环遍历当前节点  直到节点为null
        while (curNode!=null){
            //如果当前节点与最近一个不相等的节点的值不相等，那么当前节点不需要删除，更新与当前节点最近一次不相同的节点值为当前节点
            if (preNode.val!=curNode.val){
                preNode.next=curNode;
                preNode=curNode;
            }
            //当前节点指向当前节点的下一个节点
            curNode=curNode.next;
        }
        //更新preNode节点的next指针
        preNode.next=null;
        return head;
    }

    public ListNode deleteDuplicates_1(ListNode head){
        if (head==null){
            return null;
        }
        ListNode curNode=head;
        while (curNode!=null&&curNode.next!=null){
            if (curNode.val==curNode.next.val){
                curNode.next=curNode.next.next;
            }else {
                curNode=curNode.next;
            }
        }
        return head;
    }
}
