package com.nowcoder.One;

import java.util.ArrayList;
import java.util.Stack;

//BM13：判断一个链表是否为回文序列
public class BM13 {
    //方案一：通过list集合来进行判断
    public boolean isPail (ListNode head) {
        // write code here
        if (head==null)
            return false;
        ArrayList<Integer> arrayList=new ArrayList<>();
        while(head!=null){
            arrayList.add(head.val);
            head=head.next;
        }
        int j=arrayList.size()-1;
        int i=0;
        while(i<j){
            if(!arrayList.get(i).equals(arrayList.get(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
    //方案二：通过双指针（快慢指针） 来进行判断
    public boolean isPail1 (ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        //反转fast节点之后的链表
        ListNode preNode=null;
        while(fast!=null){
            ListNode curNode=fast.next;
            fast.next=preNode;
            preNode=fast;
            fast=curNode;
        }
        //遍历反转后的fast节点，判断反转后的节点顺序是否与head-slow节点的顺序一样
        slow=head;
        while(preNode!=null){
            if(preNode.val!=slow.val)
                return false;
            preNode=preNode.next;
            slow=slow.next;
        }
        return true;
    }
    //方案三：通过栈进行逆序判断
    public boolean isPail2 (ListNode head){
        Stack<ListNode> stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while(head!=null){
            if(head.val!=stack.pop().val)
                return false;
            head=head.next;
        }
        return true;
    }
}
