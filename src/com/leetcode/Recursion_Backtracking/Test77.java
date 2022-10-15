package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**77:组合问题
 *给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class Test77 {

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> lists=new ArrayList<>();
        if (n<=0||k<=0||n<k)
            return lists;
        List<Integer> list=new ArrayList<>();
        combine(lists,list,n,k,1);
        return lists;
    }

    private void combine(List<List<Integer>> lists, List<Integer> list, int n, int k,int index) {
        if (list.size()==k){
            lists.add(new ArrayList<>(list));
            return;
        }
        //剪枝操作--减少递归遍历次数
        for (int i = index; i <= n-(k-list.size())+1; i++) {
            list.add(i);
            combine(lists,list,n,k,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Test77().combine(4,2);
        for (List<Integer> list :lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
