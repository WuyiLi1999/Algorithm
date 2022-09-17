package com.eight;

/**BM84：最长公共前缀
 * 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
 */
public class BM84 {
    //空间复杂度 O(n)，时间复杂度 O(n)
    public String longestCommonPrefix (String[] strs) {
        // write code here
        //1. 判断当前字符串是否为null，如果是，直接返回""
        if (strs.length==0||strs==null)
            return "";
        //2. 遍历字符串数组，找到数组中长度最小的字符串和它所在的索引位置，初始值是字符串数组中第一个元素
        int length=strs[0].length();
        int location=0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length()<length){
                length=strs[i].length();
                location=i;
            }
        }
        //3. 遍历最短字符串的长度，找到最长公共前缀，起始值是当前字符串是最长的公共前缀，依次递减
        for (int i=length;i>0;i--){
            //3.1 截取最短字符串的子串[0...i]
            String s=strs[location].substring(0,i);
            int j=0;//判断位--判断下一个循环是否正常结束
            //3.2 遍历字符串数组，只要有一个字符串不满足以该子串为前缀，就跳出次次循环，判断下一个子串
            for (j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(s))
                    break;
            }
            //判断，循环是否正常结束（j=字符串数组的长度），正常结结束就证明该子串是最长的公共前缀
            if (j==strs.length)
                return s;
        }
        //如果没有找到最长公共前缀，返回""
        return strs[location].substring(0,0);
    }
}
