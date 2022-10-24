package com.leetcode.BinaryTree_Recursion;

public class Test112_BinaryTreePathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        //初始阶段：初始节点为null，一定不存在返回false
        if (root==null)
            return false;
        //递归结束条件：当前节点为叶子节点，并且叶子节点的值等于目标和值
        if (root.left==null&&root.right==null)
            return root.val==targetSum;
        //如果左子树不为null，递归判断左子树是否存在合为targetSum- root.val的路径
        if (root.left!=null)
            return hasPathSum(root.left,targetSum- root.val);
        //如果右子树不为null，递归判断右子树是否存在和为targetSum- root.val的路径
        if (root.right!=null)
            return hasPathSum(root.right,targetSum-root.val);
        //都不存在返回false
        return false;
    }
}
