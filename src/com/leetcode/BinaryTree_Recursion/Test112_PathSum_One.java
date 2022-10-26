package com.leetcode.BinaryTree_Recursion;

//112：判断二叉树是否存在一个从根节点到叶子节点的路径，使得了路径和为指定的target
public class Test112_PathSum_One {
    public boolean hasPathSum(TreeNode root, int targetSum){
        //初始阶段：初始节点为null，一定不存在返回false
        if (root==null)
            return false;
        //递归结束条件：当前节点为叶子节点，并且叶子节点的值等于目标和值
        if (root.left==null&&root.right==null)
            return root.val==targetSum;
        //递归判断左子树是否存在合为targetSum- root.val的路径
        if (hasPathSum(root.left,targetSum- root.val))
            return true;
        //递归判断右子树是否存在和为targetSum- root.val的路径
        if (hasPathSum(root.right,targetSum-root.val))
            return true;
        //左右子树都不存在 直接返回false
        return false;
    }
}
