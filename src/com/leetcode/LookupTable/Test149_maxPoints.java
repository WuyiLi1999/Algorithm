package com.leetcode.LookupTable;

import java.util.HashMap;

/**
 * 149:直线上最多的点
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 */
public class Test149_maxPoints {
    public int maxPoints(int[][] points) {
        if (points.length==0&&points==null){
            return 0;
        }
        //初始直线上最多的的个数为1（也就是只有一个点）
        int max=1;
        //循环遍历每一个点，计算剩余的点到这个点的所有斜率，并将斜率与斜率出现的次数存入查找哈希表中
        for (int i = 0; i < points.length; i++) {
            HashMap<String,Integer> hashMap=new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                //计算斜率（由于存在精度问题，所以用字符串存储斜率作为键）
                if (j!=i){
                    int dx=points[i][0]-points[j][0];
                    int dy=points[i][1]-points[j][1];
                    int g = gcd(dx,dy);
                    String key=(dy/g)+"/"+(dx/g);
                    hashMap.put(key,hashMap.getOrDefault(key,0)+1);
                    max=Math.max(hashMap.get(key)+1,max);
                }
            }
        }
        return max;
    }
    //计算两个数的最大公约数
    private int gcd(int dy, int dx) {
        if (dx == 0) {
            return dy;
        } else {
            return gcd(dx, dy % dx);
        }
    }

}
