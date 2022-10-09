package com.nowcoder.three;
//BM34：判断一个二叉树是否二叉搜索树
public class BM34 {
    public int maxNode=Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        // write code here
        //如果当前树的null--返回true
        if (root==null)
            return true;
        //递归遍历左子树到根节点--如果左子树的节点不满足就直接返回false
        if(!isValidBST(root.left)){
            return false;
        }
        //判断当前节点值是否比其孩子节点中的最大值要小--小证明不符合二叉搜索树的定义--返回false
        if(root.val<maxNode)
            return false;
        //更新当前节点的最大值
        maxNode=root.val;
        //判断右子树
        return isValidBST(root.right);

    }
}
