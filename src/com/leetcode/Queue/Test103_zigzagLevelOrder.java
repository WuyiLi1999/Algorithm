package com.leetcode.Queue;

import java.util.*;

//103：二叉树的锯齿形层序遍历（之字形）
public class Test103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    deque.addFirst(node.val);
                } else {
                    deque.addLast(node.val);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
            lists.add(new LinkedList<Integer>(deque));
        }
        return lists;
    }
}
