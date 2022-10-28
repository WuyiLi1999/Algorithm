package com.leetcode.Stack;

import java.util.Deque;
import java.util.LinkedList;

//20:判断括号匹配是否合法
public class Test20_isValidBrackets {
    public boolean isValid(String s) {
        if (s==null||s.length()==0)
            return true;
        Deque<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else{
                if (stack.size()==0)
                    return false;
                char c = stack.pop();
                switch (s.charAt(i)){
                    case ')':
                        if (c!='(')
                            return false;
                        break;
                    case ']':
                        if (c!='[')
                            return false;
                        break;
                    case '}':
                        if (c!='{')
                            return false;
                        break;
                    default:
                        return false;
                }
            }
        }
        return stack.size()==0;
    }
}
