package com.leetcode.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//107:二叉树的层序遍历--广度优先搜索进行层序遍历--自底向上的层序遍历
public class Test107_levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root!=null)
            queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int n= queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);

            }
            lists.add(0,list);
        }
        return lists;
    }
}
