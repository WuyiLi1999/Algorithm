package com.leetcode.Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**47:全排列问题（包含重复元素）
 *给出一组可能包含重复项的数字，返回该组数字的所有排列。结果以字典序升序排列。
 */
public class Test47 {
    //排列问题：时间复杂度O(n*n!)，空间复杂度O(nlogn)--排序所消耗的时间
    public List<List<Integer>> permuteUnique(int[] nums) {
        //用来保存结果集
        List<List<Integer>> lists=new ArrayList<>();
        if (nums.length==0||nums==null)//如果当前数组为null，没有元素，直接返回空集lists
            return lists;
        //排序，使的重复元素在一起
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();//存放当前排列中的元素
        //用来记录指定位置的元素是否已经被使用（添加到list中）
        boolean [] val=new boolean[nums.length];
        //调用递归函数进行求解
        permuteUnique(lists,list,nums,val);
        return lists;
    }

    private void permuteUnique(List<List<Integer>> lists,List<Integer> list, int[] nums, boolean[] val) {
        //递归结束条件：当list中的元素个数与nums数组元素个数一样，证明已经得到一个所有数的排列，将结果添加到结果集中，
        if (list.size()== nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        // 递归当前一层的任务：每一级都需要选择一个与前面不重复元素且未被使用过的元素（遍历数组选择）
        for (int i = 0; i < nums.length; i++) {
            if (val[i])//当前元素已经使用了，跳过接下来的判断，继续寻找未使用的元素
                continue;
            if (i>0&&nums[i-1]==nums[i]&&val[i-1])//如果当前元素未使用，但是与数组中的前一个元素相等重复，并且前一个元素被使用了，跳过
                continue;
            list.add(nums[i]);//添加到集合中
            val[i]=true;//该元素标记为已使用
            permuteUnique(lists,list,nums,val);//递归遍历，寻找下一个题意的元素
            //回溯--回溯的时候需要修改vis数组当前位置标记，同时去掉刚刚加入数组的元素，
            list.remove(list.size()-1);
            val[i]=false;
        }
    }

    public static void main(String[] args) {
        int [] nums={1,1,2};
        List<List<Integer>> lists = new Test47().permuteUnique(nums);
        for (List<Integer> list :lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
