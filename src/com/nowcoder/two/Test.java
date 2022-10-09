package com.nowcoder.two;

import java.util.Arrays;

/**
 * 1.题目: 给定一个数组,在不开辟新的内存空间的情况下将其中所有的0移动至数组开头并保持非0数组原有顺序。
 * 例:
 * 输入：[0, 8, 5, 0, 134, 0, 3, 6, 5, 0, 7, 0]
 * 输出：[0,0,0,0,0,8,5,134,3,6,5,7]
 */

public class Test {
    public static void main(String[] args) {
        int[] num ={1,0,2,0,4,5};
        for(int i=num.length-1;i>= 0;i--){
            if (num[i]!=0)
                continue;
            for (int j=i-1;j>=0;j--){
                if(num[j]!=0){
                    int number=num[i];
                    num[i]=num[j];
                    num[j]=number;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }
    public void moveZeroes(int[] nums) {
        int j=0;
        for (int k=0;k<nums.length;k++){
            if (nums[k]!=0)
                nums[j++]=nums[k];
        }
        for (int k = j; k < nums.length; k++) {
            nums[k]=0;
        }
    }
}
