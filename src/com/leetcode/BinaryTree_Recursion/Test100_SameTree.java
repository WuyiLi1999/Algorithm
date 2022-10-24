package com.leetcode.BinaryTree_Recursion;

//判断两个二叉树是否相等
public class Test100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //递归结束条件：当两个节点都为null返回true，如果连个节点只有一个为null，一定不相等，返回false
        if (p==null&&q==null)
            return true;
        else if (p==null||q==null)
            return false;
        //如果当两个节点都不为null，并且两个节点值相等，证明当前节点是相等的，递归判断当前两个节点的左右子树是否相等，左右子树相等就返回true，否则返回false
        if (p.val==q.val){
            boolean left=isSameTree(p.left,q.left);
            boolean right=isSameTree(p.right,q.right);
            return left&&right;
        }else//当前节点值都不相等，该两个二叉树一定不相等，返回false
            return false;
    }
}
