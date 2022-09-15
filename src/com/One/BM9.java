package com.One;

//删除链表中倒数第n个节点
public class BM9 {
    //方案一：先计算长度，在根据n值来找到相对应的节点，最后进行删除
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode cur=head;
        int count=0;
        //1.计算链表中元素的个数
        while (cur!=null){
            cur=cur.next;
            count++;
        }
        //如果元素个数小于元素n证明链表不够长，不删除直接返回原链表
        if (n>count)
            return head;
        //如果删除的是头结点，直接返回头结点的下一个节点
        if (n==count)
            return head.next;
        cur=head;//记录当前要删除的节点
        ListNode delNode=null;//记录当前要删除节点的前一个节点
        //循环遍历找到要删除节点的前一个节点
        while(count!=n){
            delNode=cur;
            cur=cur.next;
            count--;
        }
        //删除指定位置的节点
        delNode.next=cur.next;
        return head;
    }
    //方案二：通过双节点来确定删除节点，然后在进行节点的删除
    public ListNode removeNthFromEnd1 (ListNode head, int n){
        //添加一个虚拟头结点
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        //定义快慢两个节点
        ListNode slow=head;
        ListNode fast=head;
        ListNode delNode=dummy;//保存要删除节点的前一个节点信息
        //快节点先后移n位
        for (int i=0;i<n;i++){
            if(fast==null)
                return head;
            fast=fast.next;
        }
        //遍历找到要删除的节点位置并保存删除节点的前一个节点
        while(fast!=null){
            delNode=slow;
            slow=slow.next;
            fast=fast.next;
        }
        delNode.next=slow.next;
        return dummy.next;
    }
}
