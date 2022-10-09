package com.nowcoder.One;
//BM15:删除有序链表中的重复元素
public class BM15 {
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head==null)
            return null;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy.next;
        ListNode leftNode=dummy;
        while(cur!=null){
            if(cur.val!= leftNode.val){
                leftNode.next=cur;
                leftNode=cur;
            }
            cur=cur.next;
        }
        leftNode.next=null;
        return dummy.next;
    }
    public ListNode deleteDuplicates1 (ListNode head) {
        // write code here
        if(head==null)
            return null;
        ListNode cur=head;
        while(cur!=null&&cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else
                cur=cur.next;
        }
        return head;
    }
}
