package com.leetcode.LinkedList;

//21：合并两个有序链表
public class Test21_mergeTwoLists {
    //迭代法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyHead=new ListNode(-1);
        ListNode curNode=dummyHead;
        while (list1!=null&&list2!=null){
            if (list1.val< list2.val){
                curNode.next=list1;
                list1=list1.next;
            }else {
                curNode.next=list2;
                list2=list2.next;
            }
            curNode=curNode.next;
        }
        if (list1!=null){
            curNode.next=list1;
        }
        if (list2!=null){
            curNode.next=list2;
        }
        return dummyHead.next;
    }
    //递归法
    public ListNode mergeTwoLists_1(ListNode list1, ListNode list2) {
        if (list1==null||list2==null) {
            return list1==null?list2:list1;
        } else if (list1.val<= list2.val){
            list1.next=mergeTwoLists_1(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoLists_1(list1,list2.next);
            return list2;
        }
    }
}
