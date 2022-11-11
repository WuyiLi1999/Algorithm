package com.leetcode.LookupTable;

import java.util.HashMap;

//205:同构字符串--如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
public class Test205_isIsomorphic {
    //使用哈希表来判断一一映射关系，时间复杂度O(n)，空间复杂度o(N)--N为字符的个数（空间换时间，空间占用小，时间长）
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!=t.length())
            return false;
        HashMap<Character,Character> sMap=new HashMap<>();
        HashMap<Character,Character> tMap=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char x=s.charAt(i);
            char y=t.charAt(i);
            //sMap中的x 的对应值等于y并且tMap中y的对应值等于x  --才构成一一映射，否则不是同构字符串
            if ((sMap.containsKey(x)&&sMap.get(x)!=y)||(tMap.containsKey(y)&&tMap.get(y)!=x))
                return false;
            sMap.put(x,y);
            tMap.put(y,x);
        }
        return true;
    }
    //使用数组来判断一一映射关系（数组中存储的字符所在的索引位置+1）
    public boolean isIsomorphic_Array(String s, String t){
        if (s.length()!=t.length())
            return false;
        //定义两个数组来保存两个字符串中每一个字符所在的索引位置
        int [] arrS=new int[256];
        int [] arrT=new int[256];
        for (int i = 0; i < s.length(); i++) {
            //如果索引位置一样，继续遍历，否则就直接结束返回false
            if (arrS[s.charAt(i)]!=arrT[t.charAt(i)])
                return false;
            arrS[s.charAt(i)]=i+1;
            arrT[t.charAt(i)]=i+1;
        }
        return true;
    }
}
