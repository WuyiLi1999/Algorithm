package com.nowcoder.eight;

/**BM86:大数加法
 *以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * 数据范围：s.length,t.length <=100000，字符串仅由'0'~‘9’构成
 * 要求：时间复杂度 O(n)
 */
public class BM86 {

    public String solve (String s, String t) {
        // write code here
        if (s.length()==0)
            return t;
        if (t.length()==0)
            return s;
        //确保s中是最长的
        if (s.length()<t.length()){
            String temp=s;
            s=t;
            t=temp;
        }
        //创建字符数组保存计算结果
        char[] result=new char[s.length()];
        //标志位，判断是否发生了进位
        int flag=0;
        //遍历最长字符串s，将结果保存在字符数组中
        for (int i = s.length()-1; i >= 0; i--) {
            //计算当前位置s中的数值（加上进位）
            int num=s.charAt(i)-'0'+flag;
            //判断字符串t在当前i的位置是否为null（t是否已经处理完）--如果没有：使当前值加上t对应的值
            int j=i-s.length()+t.length();
            if(j>=0)
                num+=(t.charAt(j)-'0');
            //判断当前值是否大于等于10，进行进位处理
            if (num>=10){
                flag=1;
                num=num%10;
            }else {
                flag=0;
            }
            result[i]=(char) (num+'0');
        }

        if (flag==1)
            return "1"+String.valueOf(result);
        else
            return String.valueOf(result);
    }
}
