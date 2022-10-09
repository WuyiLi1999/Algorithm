package com.nowcoder.four;

import java.util.Stack;

//表达式求结果--栈与队列
public class BM49 {
    public int solve (String s) {
        // write code here
        int result=0;
        Stack<Integer> stack_num=new Stack<>();
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!='('||s.charAt(i)!=')'||s.charAt(i)!='+'||s.charAt(i)!='-'||s.charAt(i)!='*'||s.charAt(i)!='/')
                stack_num.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            else
                stack.add(s.charAt(i));

            if (!stack.empty()&&stack.peek()!='('){


                if (stack.peek()==')')
                    stack.pop();

                if (stack.peek()=='*')
                    result=stack_num.pop()*stack_num.pop();
                else if (stack.peek()=='/'){
                    result=stack_num.pop();
                    result=stack_num.pop()/result;
                }else if(stack.peek()=='+')
                    result=stack_num.pop()+stack_num.pop();
                else if (stack.peek()=='-'){
                    result=stack_num.pop();
                    result=stack_num.pop()-result;
                }
                stack_num.add(result);
            }
        }
        return 0;
    }
}
