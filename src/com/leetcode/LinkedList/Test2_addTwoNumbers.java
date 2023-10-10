package com.leetcode.LinkedList;

import sun.security.x509.InvalidityDateExtension;

/**
 * 2：两数相加
 * @author Smile
 */
public class Test2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位标识位
        int flag=0;
        //当前位置两个链表节点之和
        int sum=0;
        //虚拟头结点
        ListNode dummyHead=new ListNode(-1);
        //两数相加之和的新的链表节点
        ListNode sumHead=dummyHead;
        //循环遍历两个链表，直到两个链表都为null
        while (l1!=null||l2!=null){
            //如果两个链表其中一个遍历完了就赋值一个默认值 ，并求和
            int var1=l1!=null? l1.val:0;
            int var2=l2!=null? l2.val:0;
            sum=var1+var2+flag;
            //判断下一次计算是否产生进位
            if (sum>=10){
                flag=1;
            }else {
                flag=0;
            }
            //创建当前位置两个节点的和节点
            sumHead.next=new ListNode(sum%10);
            sumHead=sumHead.next;
            //更新接下来要计算的节点(如果链表提前遍历完了，就赋值一个null)
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        if (flag==1){
            sumHead.next=new ListNode(1);
        }
        return dummyHead.next;
    }
}
