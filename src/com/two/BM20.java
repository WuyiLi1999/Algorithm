package com.two;

//BM20:数组中的逆序对
public class BM20 {
    public int InversePairs(int [] array) {
        int count=0;
        for(int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j])
                    count++;
            }
        }
        count=count%1000000007;
        return count;
    }
}
