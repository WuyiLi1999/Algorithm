package com.One;

import javax.jnlp.ClipboardService;
import java.util.HashSet;

//判断链表是否存在回路
public class BM6 {
    //方案一：使用快慢两节点来进行判断
    public boolean hasCycle(ListNode head) {
        //判断链表是否为null
        if (head==null)
            return false;
        //定义快慢两个节点，慢节点一次移动一个节点；快节点一次移动两个节点
        ListNode slow=head;
        ListNode fast=head;
        //如果无环，快节点会先到链表的末尾结点
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            //如果两节点相等证明存在环，循环结束
            if (slow==fast)
                return true;
        }
        return false;
    }
    //方案二：通过哈希表来判断
    public boolean hasCycle1(ListNode head) {
        //判断链表是否为null
        if (head==null)
            return false;
        //创建一个哈希表集合
        HashSet<ListNode> hashSet=new HashSet<>();
        while(head!=null){
            //判断集合中是否存在该节点：存在-存在环-返回true，不存在-添加到集合中
            if(hashSet.contains(head))
                return true;
            hashSet.add(head);
            //当前链表节点指向下一个节点
            head=head.next;
        }
        return false;
    }
}
