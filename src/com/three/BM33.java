package com.three;

//BM33、二叉树的镜像--交换对称节点
public class BM33 {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        //当前树为null，返回null
        if (pRoot==null)
            return null;
        //当前树是叶子节点，直接返回不用在进行一次交换该叶子节点的左右子树
        if (pRoot.left==null&&pRoot.right==null)
            return pRoot;
        //递归遍历左右子树
        TreeNode left=Mirror(pRoot.left);
        TreeNode right=Mirror(pRoot.right);
        //将当前节点的左右子树交换
        pRoot.left=right;
        pRoot.right=left;
        return pRoot;


    }



}
