package com.leetcode.Dynamic_Program;

/**91.解码方式
 *
 */
public class Test91 {
    public int numDecodings(String s) {
        int n = s.length();
        //dp[i]表示字符串第i个位置解码的方式类别个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            //方式一：使用第i个字符进行解码  当前字符不为0就可以被解码
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            //方式二：使用第i-1和第i两个字符组合进行解码 只要组合字符的值小于等于26并且当前字符的前一个字符不为0
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i-2,i))<= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Test91().numDecodings("06"));
    }
}
