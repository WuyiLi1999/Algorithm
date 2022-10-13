package com.leetcode.Greed_Algorithm;

import java.util.Arrays;

/**455:分发饼干
 *
 */
public class Test455 {
    //排序 + 双指针 + 贪心
    // 时间复杂度O(mlogm+nlogn) 空间复杂度O(mlogm+nlogn)  主要是用在排序进行的时间和空间的消耗
    public int findContentChildren(int[] g, int[] s){
        //1. 首先对两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        //定义两个指针定位学生和饼干
        int m=g.length-1;
        int n=s.length-1;
        int res=0;//初始值可以让0个孩子满足
        // 贪心策略--把最大尺寸的饼干分配给胃口最大的学生（再能够满足的时候）--（递减遍历）
        while (m>=0&&n>=0){
            if (s[n]>=g[m]){//当前尺寸满足当前胃口最大的孩子 使结果+1，m，n递减
                res++;
                m--;
                n--;
            }else {//当前饼干满足不了当前孩子，因此判断下一个孩子
                m--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] g={1,2};
        int [] s={1,2,3};
        System.out.println(new Test455().findContentChildren(g,s));
    }
}
