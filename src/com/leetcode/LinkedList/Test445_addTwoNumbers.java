package com.leetcode.LinkedList;

import java.util.Stack;

/**
 * 445:两数相加
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class Test445_addTwoNumbers {
    //借用栈数据结构来计算相对应的节点的数据的相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        //将链表中的数据保存到栈内存中（利用栈内存的后进先出）
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        //求和后的链表的头结点，默认为null
        ListNode sumListNode=null;
        //是否产生进位标志
        int flag=0;
        //两个链表相对应位置的val值之和
        int sum=0;
        //循环遍历两个栈直到栈内存中的数据全部都处理完
        while (!stack1.isEmpty()||!stack2.isEmpty()||flag!=0){
            int num1=stack1.empty()?0:stack1.pop();
            int num2=stack2.empty()?0:stack2.pop();
            sum=num1+num2+flag;
            if (sum>=10){
                flag=1;
            }else {
                flag=0;
            }
            ListNode sumNode=new ListNode(sum%10);
            sumNode.next=sumListNode;
            sumListNode=sumNode;
        }
        return sumListNode;
    }
}
