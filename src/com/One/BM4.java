package com.One;
//BM4：合并两个有序的链表
public class BM4 {
    //方案一：双指针的思想
    public ListNode Merge(ListNode list1,ListNode list2) {
        //1.新建一个虚拟头结点
        ListNode newNode=new ListNode(-1);
        ListNode curNode=newNode;
        //2.遍历两个有序链表，将两个有序链表的值添加到新练得链表中
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){//list1元素小于list2元素，将list1添加到新的链表中，list1指向下一个元素
                curNode.next=list1;
                list1=list1.next;
            }else{//list1元素大于list2元素，将list2添加到新的链表中，list2指向下一个元素
                curNode.next=list2;
                list2=list2.next;
            }
            curNode=curNode.next;
        }
        //如果list1不为null 证明list1中剩下的元素比新链表中的最大元素还要大，直接添加到新链表的next域
        if(list1!=null)
            curNode.next=list1;
        //如果list2不为null 证明list2中剩下的元素比新链表中的最大元素还要大，直接添加到新链表的next域
        if(list2!=null)
            curNode.next=list2;
        return newNode.next;
    }
    //方案二：递归思想
    public ListNode Merge2(ListNode list1,ListNode list2) {
        //1.定义递归结束条件
        if(list1==null)
            return list2;
        if (list2==null)
            return list1;
        //2.递归遍历条件
        if(list1.val<=list2.val){
            //递归计算list1.next和list2，将节点值小的返回
            list1.next=Merge2(list1.next,list2);
            return list1;
        } else{
            //递归计算list1和list2.next，将节点值小的返回
            list2.next=Merge2(list1,list2.next);
            return list2;
        }
    }
}
