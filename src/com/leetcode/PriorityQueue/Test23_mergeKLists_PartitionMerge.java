package com.leetcode.PriorityQueue;

//23：合并K个有序链表--分治合并
public class Test23_mergeKLists_PartitionMerge {
    //时间复杂度O(kn×logk) 空间复杂度O(logk)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0||lists==null)
            return null;
        if (lists.length==1)
            return lists[0];

        return merge(lists,0,lists.length-1);
    }
    //将链表分成两部分
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left==right)
            return lists[left];
        if (left>right)
            return null;
        int mid=(right-left)/2+left;
        //合并两个链表
        return mergeTwoList(merge(lists,left,mid),merge(lists,mid+1,right));
    }

    //合并两个链表
    private ListNode mergeTwoList(ListNode aNode, ListNode bNode) {
        if (aNode==null||bNode==null)
            return aNode==null? bNode:aNode;
        ListNode cur=new ListNode(0);
        ListNode tail=cur;
        while (aNode!=null&&bNode!=null){
            if (aNode.val<bNode.val){
                tail.next=aNode;
                aNode=aNode.next;
            }else {
                tail.next=bNode;
                bNode=bNode.next;
            }
            tail=tail.next;
        }
        if (aNode!=null)
            tail.next=aNode;
        if (bNode!=null)
            tail.next=bNode;
        return cur.next;
    }
}

