package com.leetcode.Dynamic_Program;

import java.util.ArrayList;
import java.util.List;

/**139：单词拆分
 *给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Test139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        //dp[i]表示的是字符串s的前i的字符组成的字符串[0...i)，能否被列表中的字符串所匹配
        boolean [] dp=new boolean[n+1];
        dp[0]=true;//初始值为true 表示空串且合法
        //循环遍历 通过转移方程 计算dp[i]的值，
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int length=wordDict.get(j).length();
                //dp[i]=dp[i]||dp[i-j.length]&&j==s[i-j.length...i]
                if (i>= length)
                    dp[i]=dp[i]||(dp[i-length]&&wordDict.get(j).equals(s.substring(i-length,i)));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s="leetcode";
        List<String> wordDict=new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new Test139().wordBreak(s,wordDict));;

    }
}
