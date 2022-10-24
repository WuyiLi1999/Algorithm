package com.leetcode.BinaryTree_Recursion;

//二叉树最大深度
public class Test104_BinaryTreeMaxDepth {
    public int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

}
