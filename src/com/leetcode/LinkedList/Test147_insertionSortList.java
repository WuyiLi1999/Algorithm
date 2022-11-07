package com.leetcode.LinkedList;

//147:对链表进行插入排序
public class Test147_insertionSortList {
    //时间复杂度O(n^2)
    public ListNode insertionSortList(ListNode head) {
        if (head==null)
            return null;
        ListNode dummyHead =new ListNode(-1);//新建一个虚拟头结点
        dummyHead.next=head;
        ListNode lastSorted=head;//已经排好序的末尾节点，初始值为head（末尾结点的下一个就是待排序的节点）
        ListNode curNode=head.next;//待排序的节点，初始值为head.next
        while (curNode!=null){
            if (lastSorted.val > curNode.val){//已经有序的末尾结点值大于带排序节点的值（要插入到有序的中间）
                ListNode preNode=dummyHead;
                //找到有序链表中大于待排序节点值的前一个节点
                while (preNode.next!=null&&preNode.next.val<= curNode.val){
                    preNode=preNode.next;
                }
                //首先保存下一个要排序的节点
                lastSorted.next=curNode.next;
                //插入该节点
                curNode.next=preNode.next;
                preNode.next=curNode;
            }else {//已经有序的末尾结点值小于等于带排序节点的值（已经有序）
                //更新已经有序的末尾结点
                lastSorted=curNode;
            }
            //更新待排序的节点
            curNode=lastSorted.next;
        }
        return dummyHead.next;
    }
}
