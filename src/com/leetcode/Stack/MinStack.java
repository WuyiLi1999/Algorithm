package com.leetcode.Stack;

import java.util.Stack;

//155：最小栈--记住一个辅助栈对象，来保存栈中元素的最小值
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    //初始化堆栈对象。
    public MinStack() {
        stack=new Stack<>();
        minStack=new Stack<>();
    }
    //将元素val推入堆栈。并维护最小栈，如果最小栈不为null并且栈顶元素比推入栈中的元素要大--当前元素是最小值，推入最小栈中，
    // 如果不大于的话--就把最小栈的栈顶元素推入栈，作为当前位置的栈中最小值
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()||minStack.peek()>val)
            minStack.push(val);
        else
            minStack.push(minStack.peek());
    }
    //删除栈顶元素 。同时删除最小栈的栈顶元素，保持数据一致性
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    //获取栈顶元素
    public int top() {
        return stack.peek();
    }
    //获取栈中的最小值
    public int getMin() {
        return minStack.peek();
    }
}
