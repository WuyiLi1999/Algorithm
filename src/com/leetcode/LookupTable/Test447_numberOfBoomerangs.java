package com.leetcode.LookupTable;

import java.util.HashMap;
import java.util.Map;

//447：回旋镖的数量--枚举+哈希
public class Test447_numberOfBoomerangs {
    //时间复杂度O(n^2)，空闲复杂度O(n)
    public int numberOfBoomerangs(int[][] points) {
        if (points==null||points.length<3)
            return 0;
        int result=0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i!=j){
                    int distance=(points[i][1]-points[j][1])*(points[i][1]-points[j][1])+
                            (points[i][0]-points[j][0])*(points[i][0]-points[j][0]);
                    if (map.containsKey(distance))
                        map.put(distance,map.get(distance)+1);
                    else
                        map.put(distance,1);
                }
            }
            for (int key: map.keySet()) {
                int value=map.get(key);
                result+=value*(value-1);
            }
        }
        return result;
    }
}
