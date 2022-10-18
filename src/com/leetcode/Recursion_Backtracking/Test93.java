package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Test93 {
    //常量--IP地址的位数
    static final int SEG_COUNT = 4;
    //用来保存结果的IP地址
    List<String> list = new ArrayList<String>();
    //保存的IP地址的四个值
    int[] segments = new int[SEG_COUNT];
    //递归遍历，计算所有的IP地址
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4)//该字符串最少需要四个字符，否则构不成字符串
            return list;
        //递归寻找，从字符串第m的位置寻找IP地址第index的位置
        restoreIpAddresses(s,0,0);
        return list;
    }
    //递归寻找，从字符串第m的位置寻找IP地址第index的位置
    private void restoreIpAddresses(String s, int index, int m) {
        //递归结束条件，如果确定了IP地址的4个位置，并且当前寻找到字符串的末尾，证明找到了一个符合的IP地址，将IP地址添加到集合中
        if (index==SEG_COUNT&&m==s.length()){
            StringBuffer stringBuffer=new StringBuffer();
            for (int i = 0; i < SEG_COUNT; i++) {
                stringBuffer.append(segments[i]);
                if (i!=SEG_COUNT-1)
                    stringBuffer.append(".");
            }
            list.add(stringBuffer.toString());
            return;
        }
        //如果找到IP地址的四个位置，但是字符串没有遍历完，或者，字符串提前遍历结束，但是没有找到的IP地址的四个位置，提前结束（剪枝操作）
        if (index==SEG_COUNT&&m<s.length()||(index!=SEG_COUNT&&m==s.length())){
            return;
        }
        //如果当前字符串的位置为0，由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(m)=='0'){
            segments[index]=0;
            restoreIpAddresses(s,index+1,m+1);
        }
        //枚举每一种可能性并递归
        int res=0;
        for (int i = m; i < s.length(); i++) {
            res=res*10+(s.charAt(i)-'0');
            if (res>0&&res<=255){
                segments[index]=res;
                restoreIpAddresses(s,index+1,i+1);
            }else
                break;
        }
    }
    public static void main(String[] args) {
        List<String> list=new Test93().restoreIpAddresses("125611");
        System.out.println(list.size());
        for (String s:list) {
            System.out.println(s);
        }
    }
}
