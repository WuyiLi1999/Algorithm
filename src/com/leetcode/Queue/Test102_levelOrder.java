package com.leetcode.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102:二叉树的层序遍历--广度优先搜索 进行层序遍历
public class Test102_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> lists=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root!=null)
            queue.add(root);

        while (!queue.isEmpty()){
            int n=queue.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            lists.add(list);
        }
        return lists;

    }
}
