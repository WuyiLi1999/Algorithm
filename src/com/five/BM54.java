package com.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**BM54：三数之和--数组+双指针+排序
 *给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。
 * 空间复杂度：O(n^2)时间复杂度 O(n^2)
 */
public class BM54 {
    //时间复杂度O(n)，空间复杂度O(n)
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        //1.定义存放最后的结果集
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        //保存三个数的值，用来判断是否符合题意left+middle+right=0；并且三元组中的值是按顺序递增的
        int left,middle,right;
        //2.排序
        Arrays.sort(num);
        //3.将数组元素和对应的最后一次下标存放在HashMap中（避免结果重复）
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            hashMap.put(num[i],i);
        }
        //4.遍历数组进行判断
        for (int i = 0; i < num.length; i=hashMap.get(num[i])+1) {
            //记录三元组第一个元素的值
            left=num[i];
            for(int j=i+1;j<num.length;j=hashMap.get(num[j])+1){
                //记录三元组第二个元素的值
                middle=num[j];
                //三元组中第三个元素的值
                right=-left-middle;
                //如果第三元素的值小于第二元素，直接跳出这次循环
                if (right<middle)
                    break;
                //如果第三元素的值在集合中存在，并且第三元素的下标在第二元素的之后，该三元组才是符合题意的
                if (hashMap.get(right)!=null&&hashMap.get(right)>j){
                    ArrayList<Integer> arrayList=new ArrayList<>();
                    arrayList.add(left);
                    arrayList.add(middle);
                    arrayList.add(right);
                    lists.add(arrayList);
                }
            }
        }
        return lists;
    }
}
