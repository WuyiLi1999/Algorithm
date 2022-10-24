package com.leetcode.BinaryTree_Recursion;

//二叉树的反转
public class Test226_BinaryTreeReverse {
    public TreeNode invertTree(TreeNode root){
        //递归结束条件：当前节点为null，直接返回null
        if (root==null)
            return null;
        //反转左子树的节点
        TreeNode leftNode=invertTree(root.left);
        //反转右子树的节点
        TreeNode rightNode=invertTree(root.right);
        //交换当前节点的左右子树
        root.left=rightNode;
        root.right=leftNode;
        return root;
    }

}
