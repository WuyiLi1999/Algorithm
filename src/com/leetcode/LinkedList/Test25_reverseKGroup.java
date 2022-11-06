package com.leetcode.LinkedList;
//25:K个一组翻转链表
public class Test25_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null)
            return null;
        //建立一个虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode pre=dummyHead;//保存待翻转节点的前一个节点（已经反转好）
        ListNode end=dummyHead;//保存每一次翻转的节点的末尾（下一次要翻转的头结点）
        while (end.next!=null){
            //找到待翻转链表的末尾结点（k个）
            for (int i = 0; i < k && end!=null; i++) {
                end=end.next;
            }
            if (end==null)//待翻转的链表长度不足k个--不翻转
                break;
            //断开长度为 k 的链表
            ListNode curNode=pre.next;//保存当前要反转的K长度的链表的头结点
            ListNode next=end.next;//存接下来要翻转的长度为K的链表的头结点
            end.next=null;//断开长度为 k 的链表
            //翻转链表--返回翻转后的链表的头结点（赋值给pre.next）
            pre.next=reverse(curNode);

            curNode.next=next;//翻转之后curNode指向末尾结点，因此使用curNode与原链表的接下来要反转的节点连接起来
            pre=curNode;//将反转之后的尾端赋值给下一次要翻转的长度为K的链表的头

            end=pre;//end保存下一次要翻转的头结点
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode curNode) {
        ListNode pre=null;//已经反转的链表的头节点（初始为null）
        ListNode cur=curNode;//要反转的当前节点
        while (cur!=null){
            ListNode node=cur.next;//保存接下俩要翻转的链表头结点
            cur.next=pre;
            pre=cur;
            cur=node;
        }
        return pre;
    }
}
