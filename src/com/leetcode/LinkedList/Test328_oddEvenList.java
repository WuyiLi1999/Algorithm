package com.leetcode.LinkedList;

//328：奇偶链表
public class Test328_oddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head==null){
            return null;
        }
        //定义保存奇数位置的链表的头结点
        ListNode oddNode=new ListNode(-1);
        ListNode odd=oddNode;
        //定义保存偶数位置的链表的头结点
        ListNode evenNode=new ListNode(-1);
        ListNode even=evenNode;
        int num=1;
        //循环遍历链表，直到遍历到链表尾部
        while (head!=null){
            //判断当前节点是奇数节点还是偶数节点
            if (num%2==0){
                even.next=head;
                even=even.next;
            }else {
                odd.next=head;
                odd=odd.next;
            }
            head=head.next;
            num++;
        }
        //偶数节点的next指向null（最后位置）
        even.next=null;
        //奇数链表的next指向偶数链表的头结点
        odd.next=evenNode.next;
        return oddNode.next;
    }

    public ListNode oddEvenList_1(ListNode head){
        if (head==null){
            return null;
        }
        //奇数位置节点的头结点
        ListNode oddNode=head;
        //偶数位置节点的头结点
        ListNode evenNode=head.next;
        //循环遍历的当前节点
        ListNode curNode=evenNode;
        while (curNode!=null&&curNode.next!=null){
            //奇数节点的下一个节点为偶节点的下一个
            oddNode.next=curNode.next;
            //更新新的奇数位置节点
            oddNode=oddNode.next;
            //偶数节点的下一个位置为新的奇数位置节点的下一个
            curNode.next=oddNode.next;
            //更新偶数节点的位置
            curNode=curNode.next;
        }
        //奇节点的下一个为偶节点起始位置
        oddNode.next=evenNode;
        return head;
    }
}
