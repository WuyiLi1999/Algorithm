package com.leetcode.BinaryTree_Recursion;

import java.util.Stack;

//98:判断一棵树是否为二叉搜索树(BST)
public class Test98_isValidBST {
    //方法一：递归判断
    // 根据二叉搜索树的性质BST：左子树一定小于根节点，右子树一定大于根节点
    //      左子树的节点值一定在（Integer.MIN_VALUE，root.val），右子树一定在在（root.val,Integer.MAX_VALUE）
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        //递归判断所有节点是否满足题意
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root==null)
            return true;
        //递归结束条件：当当前节点的值不在指定区间就返回false；否则递归判断左右子树
        if (root.val>minValue&&root.val<maxValue)
            return isValidBST(root.left,minValue, root.val)&&isValidBST(root.right, root.val,maxValue);
        else
            return false;
    }
    //中序遍历（二叉搜索树中序遍历是一个递增有序序列）
    public boolean isValidBST_2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        long inOrder=Long.MIN_VALUE;

        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (root.val<=inOrder)
                return false;
            inOrder=root.val;
            root=root.right;

        }
        return true;
    }

}
