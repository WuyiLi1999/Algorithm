package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**216:组合问题三
 *找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * 只使用数字1到9
 * 每个数字 最多使用一次
 */
public class Test216 {
    //递归+回溯：时间复杂度O(9^k)
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        //从第1位置开始，当前和为0，找到k个数和为n
        combinationSum3(lists,list,k,n,1,0);
        return lists;
    }

    private void combinationSum3(List<List<Integer>> lists, List<Integer> list, int k, int n, int index, int curSum) {
        //递归结束条件：当前k个数和为n，将该组合添加到结果集中。
        if (list.size()==k&&curSum==n){
            lists.add(new ArrayList<>(list));
            return;
        }
        //递归寻找k个数使得和为n，循环结束条件，当前数不能大于9，并且集合中的数的个数要小于k才能继续寻找数
        for (int i=index;i<=9&&list.size()<k;i++){
            //如果当前数+当前数之前的组合数之和不大于n，证明该数是可以被添加到集合中
            if(curSum+i<=n){
                list.add(i);
                combinationSum3(lists,list,k,n,i+1,curSum+i);
                //回溯
                list.remove(list.size()-1);
            }else{
                break;
            }
        }
        return;
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = new Test216().combinationSum3(3,7);
        for (List<Integer> list :lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

