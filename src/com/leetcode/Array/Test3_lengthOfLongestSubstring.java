package com.leetcode.Array;

//3:无重复字符的最长子串
public class Test3_lengthOfLongestSubstring {
    //方法一：遍历从left开始所有的无重复子串
    public int lengthOfLongestSubstring(String s) {
        int [] nums=new int[256];
        int left=0;
        int right=-1;
        int maxLength=0;
        //方法一：遍历从left开始所有的无重复子串
        for (left= 0; left < s.length(); left++) {
            //减少窗口的长度
            if (left!=0){
                nums[s.charAt(left-1)]-=1;
            }
            while(right+1< s.length()&&nums[s.charAt(right+1)]==0){
                right++;
                nums[s.charAt(right)]+=1;
            }
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
    //方法二：滑动窗口
    public int lengthOfLongestSubstring_1(String s){
        int left=0,right=-1;//维护一个滑动窗口[left,right],来保存无重复的子串
        int [] freq=new int[256];//判断滑动窗口中的元素是否有重复（判断元素是否已存在）
        int maxLength=0;//记录最长的子串长度

        while (left<s.length()){
            //如果滑动窗口的下一个元素right+1 在滑动窗口中不存在 freq[s.charAt(right + 1)] == 0,该元素添加进滑动窗口中
            if (right+1<s.length()&&freq[s.charAt(right + 1)] == 0) {
                freq[s.charAt(++right)]=1;
            }else {//否则的话，移除滑动窗口左面的元素left++,直至滑动窗口中元素不重复
                freq[s.charAt(left++)]=0;
            }
            //计算滑动窗口中的子串的长度，保存最大的长度
            maxLength=Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Test3_lengthOfLongestSubstring().lengthOfLongestSubstring_1("pwwkew"));
    }
}
