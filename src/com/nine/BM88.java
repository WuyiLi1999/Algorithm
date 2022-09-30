package com.nine;

/**BM88:判断是否为回文序列————双指针
 * 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
 * 字符串回文指该字符串正序与其逆序逐字符一致。
 */
public class BM88 {
    public boolean judge (String str) {
        // write code here
        int left=0;
        int right=str.length()-1;
        while (left<=right){
            if (str.charAt(left)!=str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
