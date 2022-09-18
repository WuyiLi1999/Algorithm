package com.eight;

import java.util.Arrays;

/**BM85：验证IP地址
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址
 */
public class BM85 {
    //空间复杂度 O(n)，时间复杂度 O(n)
    public String solve (String IP) {
        // write code here
        //1. 判断该字符串是否是要进行判断是否是IPv4还是IPv6--根据字符串是否存在"."还是":"
        if (IP.split("\\.").length != 1) {//如果字符串可以被"."切割--证明可能是IPv4
            //2. 验证是否是IPv4
            //2.1 将该字符串通过"."切割
            String[] s = IP.split("\\.");
            //2.2 判断该字符串是否有4部分组成--不是：就不是IPv4
            if (s.length != 4)
                return "Neither";
            //2.3 如果由四部分组成，就一次判断每一部分是否符合IPv4的要求（只能有数字组成并且数字只能在0-255之间），如果不满足就不是IPv4，如果全部满足就是IPV4
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (s[i].charAt(j) < '0' || s[i].charAt(j) > '9')
                        return "Neither";
                }
                if (Integer.parseInt(s[i]) > 255 || Integer.parseInt(s[i]) < 0 |
                        (s[i].startsWith("0") && s[i].length() != 1)) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            //3. 验证是否是IPv6
            //3.1 将字符串通过":"切割
            String[] s = IP.split(":");
            //3.2 判断被切割后是否有8部分组成并且不能以":"结尾（2001:0db8:85a3:0:0:8A2E:0370:7334:  被切割后也是8个部分）
            if (s.length != 8||IP.endsWith(":"))
                return "Neither";
            //3.3 依次判断每一个组成部分是否满足IPV6的要求（不能出现连续的::,多余的0也是不被允许，只能由0-9 a-e A-E）
            for (int i = 0; i < s.length; i++) {
                //如果出现连续的::-->s[i].length()==0  多余的0-->s[i].startsWith("00")
                if (s[i].startsWith("00") || s[i].length()==0) {
                    return "Neither";
                }
                //判断每一部分是否由0-9 a-e A-E组成
                for (int j = 0; j < s[i].length(); j++) {
                    if (!((s[i].charAt(j)>='0'&&s[i].charAt(j)<='9')||(s[i].charAt(j)>='a'&&s[i].charAt(j)<='z')||(s[i].charAt(j)>='A'&&s[i].charAt(j)<='Z'))){
                        return "Neither";
                    }
                }
            }
            return "Ipv6";
        }
    }

    public static void main(String[] args) {
        String str="2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String[] s = str.split(":");
        System.out.println(s.length);
        for (String word:s) {
            System.out.println(word);
        }
        new BM85().solve("2001:0db8:85a3:0:0:8A2E:0370:7334");
    }
}
