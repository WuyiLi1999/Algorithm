package com.nowcoder.seven;

/**BM66：最长公共子串
 *给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 */
public class BM66 {
    //时间复杂度O(n^2)，空间复杂度O(n^2)
    public String LCS (String str1, String str2) {
        // write code here
        int [][] dp=new int[str1.length()+1][str2.length()+1];
        //记录最长公共子串的最后索引位置
        int maxLengthLastIndex=0;
        //记录最长子串的长度
        int maxLength=0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                //如果相等证明可以构成子串  递推公式：dp[i+1][j+1]=dp[i][j]+1
                if (str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                    //更新子串的长度--如果遇到了更长的子串，要更新，记录最长子串的长度，以及最长子串最后一个元素的位置
                    if (dp[i+1][j+1]>maxLength){
                        maxLength=dp[i+1][j+1];
                        maxLengthLastIndex=i;
                    }
                }
                else//如果不相等证明不能构成子串  递推公式dp[i+1][j+1]=0
                    dp[i+1][j+1]=0;

            }
        }
        //返回截取的子串
        return str1.substring(maxLengthLastIndex-maxLength+1,maxLengthLastIndex+1);
    }

    public static void main(String[] args) {
        System.out.println(new BM66().LCS("abcdefg","ab1cdefgabc1defg"));
    }
}
