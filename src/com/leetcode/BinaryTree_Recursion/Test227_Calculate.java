package com.leetcode.BinaryTree_Recursion;

import java.util.Stack;

//227：基本运算  给你一个字符串表达式，计算字符串表达式的结果
public class Test227_Calculate {
    public int calculate(String s) {
        //使用栈来保存这些（进行乘除运算后的）整数的值。
        // 对于加减号后的数字，将其直接压入栈中；对于乘除号后的数字，可以直接与栈顶元素计算，并替换栈顶元素为计算后的结果
        Stack<Integer> stackNum=new Stack<>();
        //起始运算符为+号
        char preSign='+';
        int num=0;
        for (int i = 0; i <s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                num=num*10+s.charAt(i)-'0';
            //若读到一个运算符，或者遍历到字符串末尾，即认为是遍历到了数字末尾。处理完该数字后，更新preSign为当前遍历的字符
            if (!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i==s.length()-1){
                switch (preSign){
                    case '+'://加号：将数字压入栈
                        stackNum.push(num);
                        break;
                    case '-'://减号：将数字的相反数压入栈
                        stackNum.push(-num);
                        break;
                    case '*'://乘号，将栈顶元素替换为栈顶元素与当前元素的相乘的结果
                        stackNum.push(stackNum.pop()*num);
                        break;
                    default://除号，将栈顶元素替换为栈顶元素与当前元素相除的结果
                        stackNum.push(stackNum.pop()/num);
                }
                //更新当前字符为当前遍历到的字符
                preSign=s.charAt(i);
                num=0;
            }
        }
        num=0;
        while (!stackNum.empty()){
            num+=stackNum.pop();
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Test227_Calculate().calculate("1+2*3-9/3"));
    }
}
