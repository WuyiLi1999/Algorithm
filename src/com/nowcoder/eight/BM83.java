package com.nowcoder.eight;

/**BM83:字符串变形
 *首先这个字符串中包含着一些空格，就像"Hello World"一样，然后我们要做的是把这个字符串中由空格隔开的单词反序，同时反转每个字符的大小写。
 * 进阶：空间复杂度 O(n)， 时间复杂度 O(n)
 */
public class BM83 {
    public String trans(String s, int n) {
        // write code here
        //1. 进行大小写转换
        StringBuilder stringBuilder=new StringBuilder(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)>='a'&&s.charAt(i)<='z')
                stringBuilder.append((char)(s.charAt(i)-'a'+'A')) ;
            else if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
                stringBuilder.append((char) (s.charAt(i)-'A'+'a'));
            else
                stringBuilder.append(s.charAt(i));
        }
        //2. 进行字符串反转
        stringBuilder=stringBuilder.reverse();
        //3. 将每一个翻转后的单词再翻转一次
        for (int i = 0; i < stringBuilder.length(); i++) {
            int j=i;
            //以空格为界将字符串中的单词反转
            while (j<n&&stringBuilder.charAt(j)!=' ')
                j++;
            String temp=stringBuilder.substring(i,j);
            temp=new StringBuilder(temp).reverse().toString();
            stringBuilder.replace(i,j,temp);
            i=j;
        }
        return stringBuilder.toString();
    }
}
