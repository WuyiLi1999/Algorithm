package com.leetcode.BinaryTree_Recursion;

//110：判断一刻二叉树是否为平衡二叉树--二叉树的每个节点的左右子树的高度差的绝对值不超过 1
public class Test110_BinaryTreeBalanced {
    public boolean isBalanced(TreeNode root) {
        //如果当前节点为null，他一定是平衡二叉树
        if (root==null)
            return true;
        //如果当前节点的左右子树的高度差不超过1，并且左右子树都是平衡二叉树
        return Math.abs(height(root.left)-height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    //计算二叉树的高度
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right))+1;
    }
}
