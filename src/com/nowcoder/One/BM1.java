package com.nowcoder.One;

import java.util.Stack;

/**
 * BM1:链表反转
 */
public class BM1 {
    //方法一：基于栈来实现的
    public ListNode ReverseList(ListNode head) {
        //1.判断链表是否为null，为null就直接返回null，结束
        if(head==null)
            return null;
        //2.将链表中的元素添加到栈中
        Stack<ListNode> stack=new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        //3.将栈中的元素一次出栈，形成一个新的链表
        ListNode newNode=stack.pop();
        ListNode dummy=newNode;
        while (!stack.isEmpty()){
            newNode.next=stack.pop();
            newNode=newNode.next;
        }
        //4.设置链表的尾结点指向null
        newNode.next=null;
        return dummy;
    }
    //方法二：基于双链表来实现的
    public ListNode ReverseList2(ListNode head) {
        //1.判断链表是否为null，为null就直接返回null，结束
        if(head==null)
            return null;
        //2.新建链表用来保存反转后的链表
        ListNode newList=null;
        while(head!=null){
            //2.1记录原链表当前位置的下一个节点元素
            ListNode dummy=head.next;
            //2.2将新链表的头结点设置为当前节点（每次访问的原链表的节点都会成为新链表的头结点）
            head.next=newList;
            newList=head;
            //2.3重新赋值，继续访问原链表的下一个节点
            head=dummy;
        }
        return newList;
    }
    //3.递归解决
    public ListNode ReverseList3(ListNode head) {
        //1.定义递归结束条件，当前节点为null或者当前节点的下一个节点为null，就直接返回
        if(head==null||head.next==null)
            return head;
        //2.递归函数体
        //2.1保存当前节点的下一个节点
        ListNode next=head.next;
        //2.2对下一个节点开始的链表进行反转，结果保存在reverse链表中
        ListNode reverse=ReverseList3(next);
        //2.3下一个节点的下一个节点指向当前节点
        next.next=head;
        //2.4当前节点的下一个节点设置为null
        head.next=null;
        //3.最后返回反转的链表
        return reverse;
    }
}
