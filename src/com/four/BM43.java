package com.four;

import java.util.Stack;

//BM43：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，
// 输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素。
public class BM43 {
    //用于栈的push 与 pop
    Stack<Integer> stack1 = new Stack<Integer>();
    //用于存储最小min
    Stack<Integer> stack2 = new Stack<Integer>();

    //push(value):将value压入栈中
    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()||stack2.peek()>node)
            stack2.push(node);
        else
            stack2.push(stack2.peek());

    }
    //pop():弹出栈顶元素
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    //top():获取栈顶元素
    public int top() {
        return stack1.peek();
    }
    //min():获取栈中最小元素
    public int min() {
        return stack2.pop();
    }
}
