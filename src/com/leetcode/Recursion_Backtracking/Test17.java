package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**17：电话号码的组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
 */
public class Test17 {
    public final String letters[]={
            " ",//0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz"//9

    };
    //
    List<String> list=new ArrayList<>();
    //递归+回溯(需要使用之前的结果回到之前的状态)：时间复杂度O(2^n)，空间复杂度O(n)--递归的层数
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0||digits==null)
            return list;
        //s中保存的是与digits[0...index-1]相匹配的字符串
        //寻找digits[index]相匹配的字符，将该字符添加到s的后面--得到digits[0...index]翻译得到的字符串，
        findCombinations(digits,0,"");
        return list;
    }

    private void findCombinations(String digits, int index, String s) {
        if (digits.length()==index){
            list.add(s);
            return;
        }
        char c=digits.charAt(index);
        for (int i = 0; i < letters[c-'0'].length(); i++) {
            findCombinations(digits,index+1,s+letters[c-'0'].charAt(i));
        }
    }

    public static void main(String[] args) {
        List<String> list=new Test17().letterCombinations("23");
        System.out.println(list.size());
        for (String s:list) {
            System.out.println(s);
        }
    }
}
