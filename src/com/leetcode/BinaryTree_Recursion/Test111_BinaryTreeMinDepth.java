package com.leetcode.BinaryTree_Recursion;

//111：二叉树的最小深度
public class Test111_BinaryTreeMinDepth {
    public int minDepth(TreeNode root) {
        //如果当前节点为null--返回0
        if (root==null)
            return 0;
        //递归结束条件：当前节点的左右子树都为null（叶子节点）--返回1
        if (root.left==null&&root.right==null)
            return 1;
        //对于非叶子节点--分别计算左右子树的最小深度
        int min_depth = Integer.MAX_VALUE;
        //递归遍历左子树，找到左子树的最小深度
        if (root.left!=null)
            min_depth=Math.min(minDepth(root.left),min_depth);
        //递归遍历右子树，找到右子树的最小深度
        if (root.right!=null)
            min_depth=Math.min(minDepth(root.right),min_depth);

        return min_depth+1;

    }
}
