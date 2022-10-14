package com.leetcode.Greed_Algorithm;

/**392:判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 */
public class Test392 {
    //双指针+贪心算法：时间复杂度O(m+n)，空间复杂度O(1)
    //从前往后匹配，每次贪心地匹配靠前的字符是最优决策
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        int i=0,j=0;
        while (i<m&&j<n){
            if (s.charAt(i)==t.charAt(j))
                i++;
            j++;
        }
        return i==m;
    }
    //动态规划：时间复杂度O(mn)，空间复杂度O(mn)
    //借助最长公共子序列的转移方程来判断，如果最长公共子序列的长度等于要判断的字符的长度，证明是，否则不是
    public boolean isSubsequence_D(String s, String t) {
        int m=s.length();
        int n=t.length();
        //dp[i][j]表示字符s到第i个位置，字符t到第j个位置 最长公共子序列的长度
        int [][] dp=new int[m+1][n+1];
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                //状态转移方程：如果当前字符相等，证明该位置可以添加到子序列中，因此dp[i][j]=dp[i-1][j-1]+1
                if (s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    //否则，dp[i][j]=max(dp[i-1][j],dp[i][j-1])
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        //如果dp[m][n]中的最长公共子序列的长度等于要判断字符的长度，证明是子串，否则不是
        return dp[m][n]==m;
    }
    public static void main(String[] args) {
        System.out.println(new Test392().isSubsequence_D("acb","cabdescdfb"));
    }
}
