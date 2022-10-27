package com.leetcode.BinaryTree_Recursion;

//235：二分搜索树的公共祖先
public class Test235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root==null)
            return null;
        //两个节点的值都小于根节点的值--证明两个节点都在左子树中
        if (root.val>p.val&&root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        //两个节点的值都大于根节点的值--证明两个节点在右子树中
        if (root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        //否则的话：当前节点就是分叉节点：两个节点在当前节点的左右子树中，或者，其中一个节点等于当前节点
        return root;
    }
}
