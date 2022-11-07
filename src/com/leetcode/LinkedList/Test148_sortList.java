package com.leetcode.LinkedList;

//148:对链表进行归并排序
public class Test148_sortList {
    public ListNode sortList(ListNode head) {
        if (head==null)
            return null;
        return sortList(head,null);
    }

    private ListNode sortList(ListNode head, ListNode end) {
        if (head==null)
            return null;
        if (head.next==end){//划分的链表只有一个元素的时候
            head.next=null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=end){
            slow=slow.next;
            fast=fast.next;
            if (fast!=end)
                fast=fast.next;
        }
        ListNode mid=slow;
        ListNode list1=sortList(head,mid);
        ListNode list2=sortList(mid,end);
        ListNode sorted=merge(list1,list2);
        return sorted;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1==null||list2==null)
            return list1==null?list2:list1;
        ListNode sorted=new ListNode(-1);
        ListNode curNode=sorted;
        while (list1!=null&&list2!=null){
            if (list1.val< list2.val){
                curNode.next=list1;
                list1=list1.next;
            }else {
                curNode.next=list2;
                list2=list2.next;
            }
            curNode=curNode.next;
        }
        if (list1!=null)
            curNode.next=list1;
        if (list2!=null)
            curNode.next=list2;
        return sorted.next;
    }
}
