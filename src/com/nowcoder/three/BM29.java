package com.nowcoder.three;

//判断二叉树中是否存在某一路径和为指定值
public class BM29 {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        /**递归结束条件：
         * （1）当前节点为null，表示没有路径到该节点，返回false；
         * （2）当前节点为叶子节点时，判断到该叶子节点的路径是否符合题意
         */
        if (root==null)
            return false;
        if (root.left==null&&root.right==null&&sum-root.val==0)
            return true;
        //当前节点不是叶子节点，递归调用，判断到该节点的左右子节点是否符合题意
        boolean left=hasPathSum(root.left,sum-root.val);
        boolean right=hasPathSum(root.right,sum-root.val);
        //返回最后的结果
        return left||right;
    }

}
