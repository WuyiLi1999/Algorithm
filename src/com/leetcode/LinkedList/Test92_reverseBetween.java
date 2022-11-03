package com.leetcode.LinkedList;
//92：反转指定区间的链表元素
public class Test92_reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head==null)
            return head;
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode preNode=dummyHead;//断开起始节点的前一个节点
        //找到要反转的节点的前一个节点
        for (int i = 0; i < left-1; i++) {
            preNode=preNode.next;
        }
        //切出一个子链表
        ListNode leftNode=preNode.next;
        ListNode rightNode=preNode;
        for (int i = 0; i < right-left+1; i++) {
            rightNode=rightNode.next;
        }
        //断开链表
        ListNode node=rightNode.next;
        rightNode.next=null;
        preNode.next=null;
        //子链表反转
        reverse(leftNode);
        //重新链接
        preNode.next=rightNode;
        leftNode.next=node;

        return dummyHead.next;
    }
    //反转链表中元素的指向顺序
    private void reverse(ListNode leftNode) {
        ListNode pre=null;
        ListNode cur=leftNode;//要反转的当前节点
        ListNode next=null;//要反转的下一个节点
        while (cur!=null){//循环遍历，知道要反转的节点为null
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
    }
}
