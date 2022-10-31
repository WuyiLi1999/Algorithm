package com.leetcode.Stack;


import java.util.ArrayList;
import java.util.List;

//144:二叉树前序遍历
public class Test_144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null)
            return list;
        preOrder(root,list);
        return list;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root==null)
            return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}
