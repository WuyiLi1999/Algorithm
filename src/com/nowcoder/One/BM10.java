package com.nowcoder.One;

import java.util.HashSet;

//BM10：返回两个链表的第一个公共节点
public class BM10 {
    //方案一：借助一个哈希集合来进行判断
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //1.首先将链表pHead1中的元素添加到集合中
        HashSet<ListNode> hashSet=new HashSet<>();
        while (pHead1!=null){
            hashSet.add(pHead1);
            pHead1=pHead1.next;
        }
        //2.遍历pHead2中的元素，如果相等就返回当前元素
        while (pHead2!=null){
            if (hashSet.contains(pHead2))
                return pHead2;
            pHead2=pHead2.next;
        }
        return pHead2;
    }
    //方案二：通过双指针
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2){
        //定义两个链表节点：
        ListNode left=pHead1;
        ListNode right=pHead2;
        //让两个链表走完pHead1he pHead2所有节点，不管有没有相等的节点，最终都能到达终点（left到达pHead2的终点，right到达pHead1的终点）
        while (left!=right){
            left=left==null?pHead2:left.next;
            right=right==null?pHead1:right.next;
        }
        return left;
    }
}
