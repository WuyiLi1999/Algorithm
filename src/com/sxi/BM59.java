package com.sxi;

import java.util.ArrayList;
import java.util.Arrays;

/**BM59:有重复数字的全排列问题
 * 给出一组可能包含重复项的数字，返回该组数字的所有排列。结果以字典序升序排列。
 */
public class BM59 {
    //递归+回溯--时间和空间复杂度O(n!)
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        boolean [] vis=new boolean[num.length];
        Arrays.fill(vis,false);
        permuteUnique(lists,num,list,vis);
        return lists;
    }

    private void permuteUnique(ArrayList<ArrayList<Integer>> lists,int [] num, ArrayList<Integer> list, boolean [] vis) {
        //递归终止条件：临时数组中选取了n个元素，已经形成了一种排列情况了，可以将其加入输出数组中。
        if (num.length==list.size())
            lists.add(new ArrayList<>(list));
        else {
            //每一次从头开始遍历数组————选择一个不重复元素加入到临时数组末尾（遍历数组选择）。
            for (int i = 0; i < num.length; i++) {
                //当前元素已经被使用过（添加到list中）--跳过
                if (vis[i])
                    continue;
                //当前的元素num[i]与同一层的前一个元素num[i-1]相同且num[i-1]已经用过了
                if (i>0&&num[i]==num[i-1]&&vis[i-1])
                    continue;
                vis[i]=true;
                list.add(num[i]);
                permuteUnique(lists,num,list,vis);
                vis[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}
