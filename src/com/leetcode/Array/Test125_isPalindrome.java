package com.leetcode.Array;

//125:验证回文串
//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
// 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
public class Test125_isPalindrome {
    //双指针（对撞指针）：
    public boolean isPalindrome(String s) {
        int left=0;//指向左面
        int right=s.length()-1;
        while (left<right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);
            //找到左面和右面的相对应的字符或者数字
            if (!(leftChar>='A'&&leftChar<='Z'||leftChar>='a'&&leftChar<='z'||leftChar>='0'&&leftChar<='9')){
                left++;
                continue;
            }
            if (!(rightChar>='A'&&rightChar<='Z'||rightChar>='a'&&rightChar<='z'||rightChar>='0'&&rightChar<='9')){
                right--;
                continue;
            }
            //判断左右对应的字符（不考虑大小写）和数字是否相等，是的话继续判断下一个左右对应的字符，否则的话返回false
            if (Character.toLowerCase(leftChar)==Character.toLowerCase(rightChar)){
                left++;
                right--;
            }else {
                return false;
            }
//            if (leftChar>='A'&&leftChar<='Z')
//                leftChar=(char) (leftChar+32);
//            if (rightChar>='A'&&rightChar<='Z')
//                rightChar=(char) (rightChar+32);
//            if (leftChar==rightChar){
//                left++;
//                right--;
//            }else {
//                return false;
//            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Test125_isPalindrome().isPalindrome("0P"));
    }
}
