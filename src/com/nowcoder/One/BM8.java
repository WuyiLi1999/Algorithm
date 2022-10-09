package com.nowcoder.One;
//链表中倒数最后K个节点
public class BM8 {
    //方案一：先计算长度，在根据K值来找到相对应的节点
    public ListNode FindKthToTail (ListNode pHead, int k) {
        int count=0;
        ListNode cur=pHead;
        //1.首先遍历链表计算链表长度
        while (cur!=null){
            cur=cur.next;
            count++;
        }
        //2.比较链表长度和k的大小，如果小于K说明不存在，返回null
        if(k>count)
            return null;
        //3.循环遍历链表找到倒数第K个结点
        while(count!=k){
            count--;
            pHead=pHead.next;
        }
        return pHead;
    }
    //方案二：双指针（同方向-快慢指针）
    public ListNode FindKthToTail1 (ListNode pHead, int k) {
        //1.定义快慢节点
        ListNode slow=pHead;
        ListNode fast=pHead;
        //k的值表示：快慢节点之间有K个节点，因此先找到fast节点的起始位置
        for (int i=0;i<k;i++){
            if (fast==null)//说明链表长度小于k，找不到这个位置，返回null
                return null;
            fast=fast.next;
        }
        //快慢节点依次向后移动，知道fast节点weinull-此时slow节点的位置就是倒数第k节点的位置
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
