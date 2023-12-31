package com.nowcoder.nine;

/**BM87:合并两个有序的数组
 *给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
 */
public class BM87 {
    //时间复杂度O(m+n)
    public void merge(int A[], int m, int B[], int n) {
        //保存在数组A中的元素的位置
        int k=m+n-1;
        //从后向前遍历两个数组
        while(m>0&&n>0){
            //判断两个数组当前位置的大小--保证k位置是数组A[0..m]，B[0..n]中的最大值
            if (A[m-1]>B[n-1]){//如果A当前位置大，将A[m-1]当前元素放到k位置，m--，k--
                A[k--]=A[m-1];
                m--;
            }else{//如果B当前位置大，将B[n-1]当前元素放到k位置，n--，k--
                A[k--]=B[n-1];
                n--;
            }
        }
        //判断B数组是否遍历完，如果没有遍历完，将B[0...n]继续存放在A[0..k]对应的位置上
        while(n>0){
            A[k--]=B[n-1];
            n--;
        }
    }
}
