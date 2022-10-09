package com.nowcoder.nine;

/**BM91：反转字符串
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 */
public class BM91 {
    //时间复杂度O(n)，空间复杂度O(n)
    public String solve (String str) {
        // write code here
        int length=str.length();
        char[] strs=new char[length];
        for (int i = 0; i < strs.length; i++) {
            strs[i]=str.charAt(length-i-1);
        }
        return String.valueOf(strs);
    }
    public String solve2 (String str) {
        // write code here
        int length=str.length();
        char[] strs=str.toCharArray();
        for (int i = 0; i < length/2; i++) {
            char c=strs[i];
            strs[i]=strs[length-i-1];
            strs[length-i-1]=c;
        }
        return new String(strs);
    }
}
