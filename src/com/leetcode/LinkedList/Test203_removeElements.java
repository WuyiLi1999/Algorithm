package com.leetcode.LinkedList;

//203:移除链表中指定值的元素(虚拟头结点)
public class Test203_removeElements {

    public ListNode removeElements(ListNode head, int val){
        if (head==null){
            return null;
        }
        //虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode curNode = dummyHead;
        //循环遍历当前节点的next  直到next=null
        while (curNode.next!=null){
            //判断当前节点的next节点的值是否的能与要删除的值，是的话，断开与原链表的连接
            if (curNode.next.val ==val){
                curNode.next=curNode.next.next;
            }else {
                curNode=curNode.next;
            }
        }
        return dummyHead.next;
    }
}
