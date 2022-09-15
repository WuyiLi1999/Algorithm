package com.three;

//计算二叉树的深度
public class BM28 {
    public int maxDepth (TreeNode root) {
        // write code here
        if (root==null)
            return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
