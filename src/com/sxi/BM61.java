package com.sxi;

import java.util.ArrayList;
import java.util.Arrays;

/**BM61：字符串的全排列
 *输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 */
public class BM61 {
    //递归+回溯--时间和空间复杂度O(n!)
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list=new ArrayList<>();
        if (str.length()==0)
            return list;
        //1. 将字符串变为字符数组，便于操作--并按照字符进行排序（有重复元素进行进一步判断）
        char [] s=str.toCharArray();
        Arrays.sort(s);
        //2.新建一个字符串缓冲类，用于存放已经确定位置的字符串的元素
        StringBuffer stringBuffer=new StringBuffer();
        //3. 用于记录该字符是否被使用--初始值为false（未使用）
        boolean [] val=new boolean[s.length];
        Arrays.fill(val,false);
        Permutation(list,s,stringBuffer,val);
        return list;
    }
    //递归遍历寻找到下一个元素，直至将字符串缓冲池填满，并进行回溯操作
    private void Permutation(ArrayList<String> list, char[] s,StringBuffer stringBuffer,boolean [] val) {
        //1. 递归结束条件：字符串缓冲池已经填满——找到一个字符排列，添加到集合中
        if (stringBuffer.length()==s.length)
            list.add(new String(stringBuffer));
        else {
            //循环遍历字符串
            for (int i = 0; i < s.length; i++) {
                //如果当前元素已经被使用了--跳过接下来的语句，判断下一个元素
                if (val[i])
                    continue;
                //如果当前元素和前一个元素相等，并且前一个元素被使用了--跳过接下来的语句，判断下一个元素
                if (i>0&&s[i]==s[i-1]&&val[i-1])
                    continue;
                //以上都不满足，就将当前元素添加到缓冲字符串中并修改val数组，设为已使用状态
                stringBuffer.append(s[i]);
                val[i]=true;
                //递归遍历，找到下一个元素
                Permutation(list,s,stringBuffer,val);
                //回溯操作
                val[i]=false;
                stringBuffer.deleteCharAt(stringBuffer.length()-1);
            }
        }
    }
}
