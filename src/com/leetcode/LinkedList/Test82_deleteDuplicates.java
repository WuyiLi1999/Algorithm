package com.leetcode.LinkedList;
//82:删除排序链表中的重复元素（虚拟头结点）
public class Test82_deleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode curNode=preHead;
        //如果当前节点的next与当前节点的next的next不为null ---  遍历
        while (curNode.next!=null&&curNode.next.next!=null){
            //如果当前节点的next与当前节点的next的next值相等--就删除当前节点的next的值，直到不相等
            if (curNode.next.val==curNode.next.next.val){
                int val=curNode.next.val;
                while (curNode.next!=null&&curNode.next.val==val){
                    curNode.next=curNode.next.next;
                }
            }else {//不相等--继续判断下一个节点
                curNode=curNode.next;
            }
        }
        return preHead.next;
    }
}
