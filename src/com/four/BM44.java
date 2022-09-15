package com.four;

import java.util.Stack;

//BM44：有效括号序列--判断括号是否匹配
public class BM44 {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else {
                if (stack.empty())
                    return false;
                if (s.charAt(i)==')'){
                    if (stack.pop()!='(')
                        return false;
                }
                if (s.charAt(i)==']'){
                    if (stack.pop()!='[')
                        return false;
                }
                if (s.charAt(i)=='}'){
                    if (stack.pop()!='{')
                        return false;
                }
            }
        }
        return stack.empty();
    }
}
