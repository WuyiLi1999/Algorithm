package com.three;

//BM31：二叉树判断二叉树是否对称
public class BM31 {
    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot,pRoot);
    }
    public boolean isSymmetrical(TreeNode leftNode,TreeNode rightNode){
        //两个节点都为null--他们是对称的
        if (leftNode==null&&rightNode==null)
            return true;
        //若果两个节点都不为null并且元素值相等--递归调用
        // 否则就是当两个节点只要有一个为null或者值不相等--不对称返回false
        if (leftNode==null||rightNode==null||leftNode.val!=rightNode.val)
            return false;
        else{
            return isSymmetrical(leftNode.left,rightNode.right)&&isSymmetrical(leftNode.right,rightNode.left);
        }
    }

    /*public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null)
            return true;
        if (pRoot.left==null&&pRoot.right==null)
            return true;
        else
            return isSymmetrical(pRoot.left,pRoot.right);

    }
    public boolean isSymmetrical(TreeNode leftNode,TreeNode rightNode){
        if (leftNode==null||rightNode==null)
            return leftNode==null&&rightNode==null;
        else{
            if (leftNode.val==rightNode.val)
                return isSymmetrical(leftNode.left,rightNode.right)&&isSymmetrical(leftNode.right,rightNode.left);
            else
                return false;
        }
    }*/
}
