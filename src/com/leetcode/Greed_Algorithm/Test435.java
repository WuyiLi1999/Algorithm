package com.leetcode.Greed_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**435：无重叠区间
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。

 */
public class Test435 {
    //贪心算法：时间复杂度与空间复杂度O(nlogn) 具体的消耗在于对数组元素进行排序，在求解最长无重叠区间的时间复杂度为O(n)，空间复杂度为O(1)
    public int eraseOverlapIntervals(int[][] intervals){
        //对二维数组进行排序递增的顺序--按照第二个元素的大小进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int pre=0;//起始的第一个区间，一开始为排序的第一个区间
        int res=1;//最长区间起始为1，第一个区间
        for (int i=1;i<intervals.length;i++){
            //如果前一个区间的结尾小于等于下一个区间的开始，证明是两个区间是无重叠的，结果+1，前一个区间的索引位置指向当前区间索引
            if (intervals[i][0]>=intervals[pre][1]){
                res++;
                pre=i;
            }
        }
        //返回区间个数-最长无重复区间
        return intervals.length-res;
    }
    //动态规划：时间复杂度O(n^2)，空间复杂度O(nlogn)--排序所需要的空间，在进行动态转移方程时的时间复杂度为O(n^2)空间复杂度O(n)
    public int eraseOverlapIntervals_D(int[][] intervals){
        int n=intervals.length;
        //dp[i]中记录的是，以第i个区间为结尾的最长无重叠区间的个数
        int [] dp=new int[intervals.length];
        //按照区间的起始位置进行排序，起始位置相等，按照结束位置进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0])
                    return o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });
        //为dp数据赋初值1
        Arrays.fill(dp,1);
        int max=1;//max记录最长无重叠区间的长度
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //转移方程：dp[i]=max(dp[i],dp[j]+1)
                if (intervals[i][0]>=intervals[j][1])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(dp[i],max);
        }
        return intervals.length-max;
    }


}
