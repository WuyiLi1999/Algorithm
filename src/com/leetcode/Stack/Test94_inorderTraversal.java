package com.leetcode.Stack;

import java.util.ArrayList;
import java.util.List;

public class Test94_inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null)
            return list;
        inOrder(root,list);
        return list;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root==null)
            return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
