package com.nowcoder.nine;

/**BM9:最小覆盖子串--哈希+双指针
 * 给出两个字符串 s 和 t，要求在 s 中找出最短的包含 t 中所有字符的连续子串。
 * 保证s和t字符串中仅包含大小写英文字母
 */
public class BM90 {

    public boolean determineHashValue(int [] hash){
        for (int i = 0; i < hash.length; i++) {
            if (hash[i]<0)
                return false;
        }
        return true;
    }
    //时间复杂度O(ls*lt),空间复杂度O(lt)
    public String minWindow (String S, String T) {
        // write code here
        //1. 建立哈希表，遍历字符串T，统计各个字符出现的频率，频率计为负数。
        int [] hash=new int[128];
        for (int i = 0; i < T.length(); i++) {
            hash[T.charAt(i)]-=1;
        }
        //记录左右区间
        int left=-1,right=-1;
        //快慢指针移动
        int slow=0,fast=0;
        //初始化记录截取子串的长度--在S的长度上+1
        int length=S.length()+1;
        //依次遍历字符串S，如果匹配则将哈希表中的相应的字符加1。
        for (; fast < S.length(); fast++) {
            //将当前字符添加进去，判断是否包含子串，如果不包含继续寻找，
            // 包含的话就依次向后移动slow，找到长度最小并满足包含子串
            char c=S.charAt(fast);
            hash[c]+=1;
            //循环找到满足包含子串并且长度最小的left和right位置--
            // 则窗口收缩向左移动，找最小的窗口，如果不满足这个条件则窗口右移继续匹配。窗口移动的时候需要更新最小窗口，以取得最短子串。
            while (determineHashValue(hash)){
                if(length>fast-slow+1){
                    left=slow;
                    right=fast;
                    length=fast-slow+1;
                }
                hash[S.charAt(slow)]-=1;
                slow++;
            }
        }
        if (left==-1)
            return "";
        return S.substring(left,right+1);
    }
}
