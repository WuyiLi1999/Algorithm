package com.One;
//BM2链表指定区间反转
public class BM2 {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head==null)
            return null;
        //1.设置一个虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        //2.找到反转的起始位置和结束位置
        ListNode preHead=dummyHead;//preNode节点是开始反转节点的前一个节点
        for (int i=0;i<m-1;i++){
            preHead=preHead.next;
        }
        ListNode rightNode=preHead;//rightNode节点是要反转的末尾节点
        for (int i=0;i<n-m+1;i++){
            rightNode=rightNode.next;
        }
        //3.截出子链表--leftNode
        ListNode leftNode=preHead.next;
        preHead.next=null;
        ListNode cur=rightNode.next;
        rightNode.next=null;
        //4.链表反转--leftNode是反转之后链表的尾结点
        reverseList(leftNode);
        //5.拼接链表
        preHead.next=rightNode;
        leftNode.next=cur;

        return dummyHead.next;

    }
    //反转链表
    public void reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode cur_next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=cur_next;
        }
    }
}
