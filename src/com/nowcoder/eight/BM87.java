package com.nowcoder.eight;

/**BM87：判断是否是回文序列
 * 给定一个长度为 n 的字符串，请编写一个函数判断该字符串是否回文。如果是回文请返回true，否则返回false。
 * 字符串回文指该字符串正序与其逆序逐字符一致。
 */
public class BM87 {
    //时间复杂度O(n)，空间复杂度O(1)
    public boolean judge (String str) {
        // write code here
        //定义两个左右指针，分别指向字符串的起始位置和末尾位置
        int left=0;
        int right=str.length()-1;
        //循环遍历字符串，结束条件为
        while (left<=right){
            //判断左右指针对应的元素是否相等，不相等返回false否则判断下一个
            if (str.charAt(left)!=str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
