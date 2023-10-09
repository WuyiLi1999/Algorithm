package com.leetcode.LinkedList;

/**
 * 206：链表反转
 * @author Smile
 */
public class Test206_reverseList {
    //时间复杂度O(n)，空间复杂度O(1)
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        //已经反转的链表的头节点（初始为null）
        ListNode pre=null;
        //当前要反转的链表节点
        ListNode cur=head;
        //要反转节点的下一个节点
        ListNode next=null;
        //循环遍历，直到要反转的节点为null
        while (cur!=null){
            next=cur.next;//首先记录接下里要反转的链表节点（防止数据丢失）
            cur.next=pre;//当前要反转的链表节点的next节点指向已经反转的链表的表头（）断开之前的联系
            pre=cur;//已经反转的链表表头更新为反转之后的新节点
            cur=next;//更新接下来要反转的链表节点
        }
        return pre;
    }
}
