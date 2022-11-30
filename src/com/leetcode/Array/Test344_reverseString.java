package com.leetcode.Array;

//344:反转字符串
//将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出
public class Test344_reverseString {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        while (left<right){
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
