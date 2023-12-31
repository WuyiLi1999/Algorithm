package com.leetcode.PriorityQueue;
//23:合并K个有序链表--顺序合并
public class Test23_mergeKLists_OrderMerge {
    //时间复杂度O(k^2n)，空间复杂度O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0||lists==null)
            return null;
        if (lists.length==1)
            return lists[0];
        ListNode node=null;
        for (int i = 0; i < lists.length; i++) {
            node=mergeTwoList(node,lists[i]);
        }
        return node;
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

