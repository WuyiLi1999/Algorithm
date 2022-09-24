package com.nine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
/**BM89:合并两个区间
 * 给出一组区间，请合并所有重叠的区间。保证合并后的区间按区间起点升序排列。
 * 时间复杂度O(nlogn)，空间复杂度O(n)
 */
public class BM89 {
    //时间复杂度O(nlogn)，空间复杂度O(n)
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        //1.新建一个集合用来存储合并之后的结果
        ArrayList<Interval> list=new ArrayList<>();
        if (intervals.size()==0)
            return list;
        //2.对待合并的集和进行排序，按照起始位置升序排序（起始位置相等按照结尾元素升序排序）
        //时间复杂度O(nlogn)
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                //如果起始点相同，判断结尾的大小，否则的话判断起始点的大小
                if (o1.start==o2.start)
                    return o1.end-o2.end;
                else
                    return o1.start-o2.start;
            }
        });
        //起始默认第一个元素是合并之后的，一次遍历剩下的集合元素进行合并
        list.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            //获取合并好的集合的末尾元素
            Interval interval1=list.get(list.size()-1);
            //获取当前待合并的元素
            Interval interval2=intervals.get(i);
            //如果待合并的元素起始位置元素值小于等于已经合并好的元素的末尾位置的元素值--待合并的元素要进行合并，
            // 否则不需要进行合并，将该元素添加到合并好的集合中
            if (interval1.end>=interval2.start){
                list.remove(interval1);//移除已经合并好的元素
                Interval s=new Interval(interval1.start,interval2.end);//创建新的合并之后的元素
                //判断合并之后的元素的末尾值是否比之前合并好的末尾值大大小，
                if (s.end<interval1.end)// 如果小于--证明待合并的元素是合并之前的一个子集，将合并元素的末尾更新为原来的末尾值
                    s.end=interval1.end;
                //将合并之后的值添加到合并之后的集和中
                list.add(s);
            }else{
                list.add(interval2);
            }
        }
        return list;
    }
}
