package com.leetcode.LinkedList;

//237：删除链表中的节点（链表的所有值都是 唯一的）
public class Test237_deleteNode {
    public void deleteNode(ListNode node) {
        if(node==null)//待删除的节点为null--直接退出
            return;
        if (node.next==null){//待删除的节点是链表的最后一个节点--该节点为null
            node=null;
            return;
        }
        //通过改变节点的值来达到删除节点（让链表中不在出现该节点值）
        node.val=node.next.val;
        ListNode delNode=node.next;
        node.next=delNode.next;
        return;
    }
}
