package com.leetcode.LookupTable;

import java.util.HashMap;
import java.util.Map;

//447：回旋镖的数量--枚举+哈希
public class Test447_numberOfBoomerangs {
    //时间复杂度O(n^2)，空闲复杂度O(n)
    public int numberOfBoomerangs(int[][] points){
        //1. 如果数组元素不足3个元素或者数组为null直接返回0
        if (points.length<3||points==null) {
            return 0;
        }
        int result=0;
        //确认起始点并循环遍历二维数组，找到剩下所有点到这个点的距离，将这些数据存放到哈希表中（以距离为键，该距离出现的次数为值）
        for (int i = 0; i < points.length; i++) {
            //保存其他点到当前第i个坐标点的所有距离的一个查找表
            HashMap<Integer,Integer> hashMap=new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i!=j){
                    //计算距离，并更新查找表
                    int distince=(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+
                            (points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                    hashMap.put(distince,hashMap.getOrDefault(distince,0)+1);
                }
            }
            //遍历当前第i个坐标的查找表，因为需要考虑到元组的顺序，所以第i坐标的回旋镖的数量=相同距离点的个数*(相同距离点的个数-1)
            for (Integer key: hashMap.keySet()) {
                int value= hashMap.get(key);
                if (value>=2){
                    result+=(value-1)*value;
                }
            }
        }
        return result;
    }
}
