package com.leetcode.BinaryTree_Recursion;

//判断二叉树是否对称
public class Test101_BinaryTreeSymmetric {
    //一个树的左子树与右子树镜像对称，那么这个树是对称的
    //两个树互为镜像条件：1.它们的两个根结点具有相同的值，2.每个树的右子树都与另一个树的左子树镜像对称
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root,root);
    }
    //判断两个树是否对称（镜像）
    private boolean checkSymmetric(TreeNode p, TreeNode q) {
        //如果两个树都是null，证明是对称镜像
        if (p==null&&q==null)
            return true;
        else if (p==null||q==null)//如果一个为null，另一个不为null，返回false，不对称
            return false;
        //如果两个树的根节点值相等，递归判断，每棵树的右子树是否与另一个树的左子树对称
        if (p.val==q.val)
            return checkSymmetric(p.left,q.right)&&checkSymmetric(p.right,q.left);
        else//否则返回false
            return false;
    }
}
