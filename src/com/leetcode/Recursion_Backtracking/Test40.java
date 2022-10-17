package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**40：组合总和（元素不可以重复使用）
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 */
public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists=new ArrayList<>();
        if (candidates.length==0||candidates==null||candidates[0]>target)
            return lists;
        List<Integer> list=new ArrayList<>();
        combinationSum2(lists,list,candidates,target,0,0);
        return lists;
    }

    private void combinationSum2(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int index, int curSum) {
        if (target==curSum){
            if (!lists.contains(new ArrayList<>(list)))
                lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (curSum+candidates[i]>target)
                break;
            list.add(candidates[i]);
            combinationSum2(lists,list,candidates,target,i+1,curSum+candidates[i]);
            list.remove(list.size()-1);
        }
        return;
    }

    public static void main(String[] args) {
        int [] nums={1,1,2,5,6,7,10};
        //System.out.println(nums.length);
        List<List<Integer>> lists = new Test40().combinationSum2(nums,8);
        for (List<Integer> list :lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
