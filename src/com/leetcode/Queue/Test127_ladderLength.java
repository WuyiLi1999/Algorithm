package com.leetcode.Queue;

import java.util.*;
//127：单词接龙----给你两个单词 beginWord和 endWord 和一个字典 wordList ，
// 返回 从beginWord 到endWord 的 最短转换序列 中的 单词数目，不存在返回0

public class Test127_ladderLength {
    //存放以每一个单词及其虚拟节点为键，单词所在的位置编号为值
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    //存放的是每一个位置  可以与那些位置相连接
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;//起始位置为0

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //构造每一个单词及其虚拟节点的边，并构造一张无向图
        for (String word : wordList) {
            addEdge(word);
        }
        //构造初始节点和其对应的虚拟节点所对应的边，并添加到无向图中
        addEdge(beginWord);
        //如果不包含endWord证明组成不了一个路径从而构成endWord
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        //记录到达每一个单词所需要转换的最小次数--初始值为最大值
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        //从beginID开始，endID结束
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;//初始值为0

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);//将初始单词添加到队列中，并广度优先遍历从初始节点到图中的所有路径，记录到达该单词编号所需要最小的遍历次数
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {//如果广度遍历到目标end单词，返回遍历次数
                return dis[endId] / 2 + 1;
            }
            //否则的话继续广度遍并记录到达当前位置遍历的最小次数
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {//已经遍历到（记录过）不需要更新，跳过，如果没有记录过，就计算到达当前单词所需要的遍历次数
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }
    //为每一个单词和其三个虚节点添加无向边来构造无向图
    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}
