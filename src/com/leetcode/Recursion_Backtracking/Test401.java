package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

/**401：二进制手表
 *
 */
public class Test401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i)+Integer.bitCount(j)==turnedOn)
                    list.add(i+":"+(j<10?"0"+j:j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list=new Test401().readBinaryWatch(1);
        System.out.println(list.size());
        for (String s:list) {
            System.out.println(s);
        }
    }

}
