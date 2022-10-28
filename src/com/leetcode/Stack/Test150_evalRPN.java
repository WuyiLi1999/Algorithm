package com.leetcode.Stack;

import java.util.Deque;
import java.util.LinkedList;

//150：逆波兰表达式--每一次遇到一个运算符，就取出两个数字做运算，并将运算结果作为下一次要运算的数
public class Test150_evalRPN {
    //时间复杂度O(n)，空间复杂度O(n)
    public int evalRPN(String[] tokens) {
        //存放要计算的数字
        Deque<Integer> stack=new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isNumber(tokens[i]))//如果当前字符串是数字，就添加到栈中
                stack.push(Integer.parseInt(tokens[i]));
            else{
                //当前字符串不是数字，出栈两个元素做相应的计算
                int n=stack.pop();
                int m=stack.pop();
                //根据运算符来判断要进行的计算
                switch (tokens[i]){
                    case "*":
                        stack.push(n*m);
                        break;
                    case "/":
                        stack.push(m/n);
                        break;
                    case "+":
                        stack.push(n+m);
                        break;
                    case "-":
                        stack.push(m-n);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String string) {
        return !("+".equals(string)||"-".equals(string)||"*".equals(string)||"/".equals(string));
    }
}
