package com.seven;

/**BM65：最长公共子序列
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
 */
public class BM65 {
    public String LCS (String s1, String s2) {
        // write code here
        int length1=s1.length();
        int length2=s2.length();
        //maxLength[i][j]表示第一个字符串到第i位，第二个字符串到第j位为止的最长公共子序列长度
        int [][] maxLength=new int[length1+1][length2+1];
        //动态规划数组相加的方向
        int [] [] dp=new int[length1+1][length2+1];
        for (int i = 1; i < maxLength.length; i++) {
            for (int j = 1; j < maxLength[i].length; j++) {
                //若是i位与j位的字符相等，则该问题可以变成1+maxLength[i−1][j−1]，即到此处为止最长公共子序列长度由前面的结果加1
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    maxLength[i][j]=maxLength[i-1][j-1]+1;
                    //左上方
                    dp[i][j]=1;
                } else {
                    //说明到此处为止的子串，最后一位不可能同时属于最长公共子序列，
                    // 因此我们考虑换成两个子问题，dp[i][j−1]或者dp[i−1][j]，我们取较大的一个就可以了
                    if(maxLength[i-1][j]>maxLength[i][j-1]){
                        maxLength[i][j]=maxLength[i-1][j];
                        //向上
                        dp[i][j]=2;
                    }else{
                        maxLength[i][j]=maxLength[i][j-1];
                        //向左
                        dp[i][j]=3;
                    }
                }
            }
        }
        String result=selectStr(dp,s1,length1,length2);
        if (result.isEmpty())
            return "-1";
        return result;
    }

    private String selectStr(int[][] dp, String s1, int length1, int length2) {
        String res="";
        //递归结束条件
        if (length1==0||length2==0)
            return res;
        //根据方向，往左上方递归，然后添加本级字符
        if (dp[length1][length2]==1){
            res+=selectStr(dp,s1,length1-1,length2-1);
            res+=s1.charAt(length1-1);
        }else if(dp[length1][length2]==2){//向左递归遍历
            res+= selectStr(dp,s1,length1-1,length2);
        }else if(dp[length1][length2]==3){//向上递归遍历
            res+= selectStr(dp,s1,length1,length2-1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BM65().LCS("1A2C3D4B56","B1D23A456A"));
    }
}
