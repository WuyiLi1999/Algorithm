package com.eight;

/**BM83:字符串变形
 *首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 * 进阶：空间复杂度 O(n)， 时间复杂度 O(n)
 */
public class BM83 {
    public String trans(String s, int n) {
        // write code here
        StringBuilder stringBuilder=new StringBuilder(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='a'&&s.charAt(i)<='z')
                stringBuilder.append((char)(s.charAt(i)-'a'+'A')) ;
            else if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
                stringBuilder.append((char) (s.charAt(i)-'A'+'a'));
            else
                stringBuilder.append(s.charAt(i));
        }

        s=stringBuilder.toString();
        StringBuilder s1=new StringBuilder(n);
        if (s.endsWith(" "))
            s1.append(" ");

        String [] ss=s.split(" ");
        for (int i =ss.length-1 ; i >0 ; i--) {
            s1.append(ss[i]+" ");
        }
        s1.append(ss[0]);
        return s1.toString();
    }
}
