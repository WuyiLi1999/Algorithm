package com.leetcode.BinaryTree_Recursion;

//437:路径总和，计算二叉树中路径和为targetSum的所有路径个数（可以从任意节点出发向下寻找路径）
public class Test437_PathSum_Three {
    public int pathSum(TreeNode root, int targetSum){
        if (root==null)
            return 0;
        int sum=findPath(root,targetSum);
        sum+=pathSum(root.left,targetSum);
        sum+=pathSum(root.right,targetSum);
        return sum;
    }

    private int findPath(TreeNode root, long targetSum) {
        if (root==null)
            return 0;
        int num=0;
        targetSum-=root.val;
        if (targetSum==0)
            num+=1;
        num+=findPath(root.left,targetSum);
        num+=findPath(root.right,targetSum);
        return num;
    }
}
