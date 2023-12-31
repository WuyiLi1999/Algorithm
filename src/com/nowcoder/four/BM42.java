package com.nowcoder.four;

import java.util.Stack;
//BM42:使用两个栈来实现队列
public class BM42 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int num=stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return num;
    }
}
