package com.seven;

import java.util.Arrays;

/**BM83：最长回文子串
 *对于长度为n的一个字符串A（仅包含数字，大小写英文字母），请设计一个高效算法，计算其中最长回文子串的长度。
 */
//贪心思想+中心扩展法
public class BM73 {
    //时间复杂度O(n^2)，空间复杂度O(1)
    public int getLongestPalindrome (String A) {
        // write code here
        int maxLength=1;
        for (int i = 0; i < A.length()-1; i++) {
            //记录当前位置的最大回文子串
            //fun(A,i,i)--以A[i]为中心的奇数长度的回文序列长度
            //fun(A,i,i+1)--以i,j两个字符串为中心的偶数长度的回文序列长度
            maxLength=Math.max(maxLength,Math.max(fun(A,i,i),fun(A,i,i+1)));
        }
        return maxLength;
    }
    //以a[i，j]为中心点的回文字符串的长度:i==j是求一i为中心的奇数长度的回文序列，i与j不相等相差1是求以a[i]a[j]两个为中心的偶数长度的回文序列
    private int fun(String a, int i, int j) {
        while (i>=0&&j<a.length()&&a.charAt(i)==a.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

}
