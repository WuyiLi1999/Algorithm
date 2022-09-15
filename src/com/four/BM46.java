package com.four;

import java.util.ArrayList;

//BM46:最小的K个数
public class BM46 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        //判断当前数组是否为null或者k值是否小于数组长度
        if(input==null||input.length<k)
            return null;
        //选择排序法--每一次确定一个最小值，因此只需要K次就可以确定最小的K个数
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<k;i++){
            int temp=input[i];
            int position=i;
            for (int j=i;j<input.length;j++){
                if (temp>input[j]){
                    temp=input[j];
                    position=j;
                }
            }
            int swap=input[i];
            input[i]=input[position];
            input[position]=swap;
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        int [] nums={4,5,1,6,2,7,3,8};
        ArrayList<Integer> list=new BM46().GetLeastNumbers_Solution(nums,4);
        System.out.println(list);
    }
}
