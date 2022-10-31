package com.leetcode.Stack;

import java.util.ArrayList;
import java.util.List;

public class Test145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null)
            return list;
        postOrder(root,list);
        return list;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root==null)
            return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }
}
