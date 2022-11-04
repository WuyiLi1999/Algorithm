package com.leetcode.LinkedList;

//328：奇偶链表
public class Test328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return head;
        ListNode oddNode=new ListNode(-1);
        ListNode odd=oddNode;
        ListNode evenNode=new ListNode(-1);
        ListNode even=evenNode;
        int num=1;
        while (head!=null){
            if (num%2==0){
                even.next=head;
                even=even.next;
            }else {
                odd.next=head;
                odd=odd.next;
            }
            num++;
            head=head.next;
        }
        even.next=null;
        odd.next=evenNode.next;
        return oddNode.next;
    }
    public ListNode oddEvenList_1(ListNode head) {
        if (head==null)
            return head;
        ListNode oddNode=head;
        ListNode evenNode=head.next;
        ListNode even=evenNode;
        while (even!=null&&even.next!=null){
            oddNode.next=even.next;//奇节点的下一个节点为偶节点的下一个
            oddNode=oddNode.next;//新的奇节点
            even.next=oddNode.next;//偶节点的下一个为新的奇节点的下一个
            even = even.next;//新的偶节点
        }
        //奇节点的下一个为偶节点起始位置
        oddNode.next=evenNode;
        return head;
    }
}
