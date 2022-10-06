package com.seven;

/**BM69：将数字翻译成字符串
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * 现在给一串数字，返回有多少种可能的译码结果
 */
public class BM69 {
    //动态规划：时间复杂度O(n) 空间复杂度O(n)
    public int solve (String nums) {
        // write code here
        //排除0
        if(nums.equals("0"))
            return 0;
        //排除只有一种可能的10 和 20
        if(nums.equals("10") || nums.equals("20"))
            return 1;
        //当0的前面不是1或2时，无法译码，0种
        for(int i = 1; i < nums.length(); i++){
            if(nums.charAt(i) == '0')
                if(nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2')
                    return 0;
        }
        //dp[i]中表示字符串前i个数的译码方法有多少种
        int [] dp=new int[nums.length()+1];
        dp[0]=1;//初始第一个位置1
        dp[1]=1;//第一个字符初始值可以转换成字符串的格式为1
        //对于一个数，我们可以直接译码它，也可以将其与前面的1或者2组合起来译码：如果直接译码，则dp[i]=dp[i−1]；如果组合译码，则dp[i]=dp[i−2]
        for (int i = 2; i <dp.length; i++) {
//            System.out.print(Integer.parseInt(nums.substring(i-2,i))+":");
            //当当前i-1位置的元素不为0并且[i-2,1-1]两个元素组成的数字小于等于26并且第i-2位置不能为0
            // 该位置有两种选择，直接译码和和前一个组合成一个新的组合码
            //动态转移方程：dp[i]=dp[i-1]+dp[i-2]
            if (nums.charAt(i-1)!='0'&&Integer.parseInt(nums.substring(i-2,i))<=26&&nums.charAt(i-2)!='0')
                    dp[i]=dp[i-1]+dp[i-2];
            else//如果不能与前一个组成一个新的码：转移方程为：dp[i]=dp[i-1]
                dp[i]=dp[i-1];
//            System.out.println(dp[i]);
        }
        return dp[nums.length()];
    }

    public static void main(String[] args) {
        System.out.println(new BM69().solve("72910721221427251718216239162221131917242"));
    }
}
