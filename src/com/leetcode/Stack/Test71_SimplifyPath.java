package com.leetcode.Stack;

import java.util.Deque;
import java.util.LinkedList;

//71:路径简化
public class Test71_SimplifyPath {
    public String simplifyPath(String path) {
        String [] s=path.split("/");
        Deque<String> stack=new LinkedList<>();
        for (int i = 0; i < s.length; i++) {
            if ("..".equals(s[i])){
                if (!stack.isEmpty())
                    stack.pop();
            } else if (s[i].length()>0&&!(".".equals(s[i])))
                    stack.push(s[i]);
        }
        StringBuffer buffer=new StringBuffer();
        if (stack.isEmpty())
            buffer.append("/");
        else
            while (!stack.isEmpty()){
                buffer.append("/");
                buffer.append(stack.pollLast());
            }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Test71_SimplifyPath().simplifyPath("/home/foo"));
    }
}
