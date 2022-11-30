package com.leetcode.Array;

//345：反转字符串中的元音字母
//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
public class Test345_reverseVowels {
    //双指针来判断寻找对应的左右两个元音字母所在的索引位置
    public String reverseVowels(String s) {
        int left=0;
        int right=s.length()-1;
        char[] charArray = s.toCharArray();

        while (left<right){
            //寻找到左面对应的元音字母索引位置
            while (left<s.length()&&!isVowels(charArray[left])){
                left++;
            }
            //寻找到右面对应的元音字母索引位置
            while (right>0&&!isVowels(charArray[right])){
                right--;
            }
            //如果左面的位置小于右面的，交换两个元音字母
            if (left<right){
                char temp=charArray[left];
                charArray[left]=charArray[right];
                charArray[right]=temp;
                left++;
                right--;
            }
        }
        return new String(charArray);
    }

    private boolean isVowels(char charAt) {
        return "aeiouAEIOU".indexOf(charAt)>=0;
    }

    public static void main(String[] args) {
        System.out.println(new Test345_reverseVowels().reverseVowels("ai"));
    }


}
