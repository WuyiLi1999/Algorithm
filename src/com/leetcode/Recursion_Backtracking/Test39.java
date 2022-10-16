package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**39：组合总和
 *给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 */
public class Test39 {
    //递归+回溯：时间复杂度O(n*n!)，空间复杂度O(nlogn) 排序所消耗的空间，递归调用栈O(n)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //对数组进行排序从小到大排序
        Arrays.sort(candidates);
        //用来保存所有的组合
        List<List<Integer>> lists=new ArrayList<>();
        //如果当前数组元素为null，或者数组中的第一个元素都比目标和要大，证明不存在，直接返回
        if (candidates.length==0||candidates==null||candidates[0]>target)
            return lists;
        //保存一个组合
        List<Integer> list=new ArrayList<>();
        //递归遍历：寻找元素和curSum为target的一个组合，从数组中的第0个元素开始，元素和初始为0
        combinationSum(lists,list,candidates,target,0,0);
        return lists;
    }

    private void combinationSum(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int index,int curSum) {
        //递归结束条件：当前元素和等于target，证明找到一个组合，将该组合添加到结果集中
        if (target==curSum){
            lists.add(new ArrayList<>(list));
            return;
        }
        //从当前位置开始，判断当前元素是否可以添加到组合中
        for (int i = index; i < candidates.length; i++) {
            //如果当前元素和之前的元素和相加结果大于了target，证明不能使用该元素，跳过这次循环
            //否则的话，将该元素添加到集合中，curSum=curSum+当前元素，递归遍历，找到下一个可以添加的元素
            if (target-curSum<candidates[i])
                continue;
            list.add(candidates[i]);
            combinationSum(lists,list,candidates,target,i,curSum+candidates[i]);
            //回溯操作，从集合中移除添加的元素，判断该元素的下一个元素是否满足
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        int [] nums={2,3,6,7};
        List<List<Integer>> lists = new Test39().combinationSum(nums,7);
        for (List<Integer> list :lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
