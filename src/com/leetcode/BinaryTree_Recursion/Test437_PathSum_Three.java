package com.leetcode.BinaryTree_Recursion;

//437:路径总和，计算二叉树中路径和为targetSum的所有路径个数（可以从任意节点出发向下寻找路径）
public class Test437_PathSum_Three {
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null)
            return 0;
        //计算包含root，所有符合题意的路径个数
        int sum=findPath(root,targetSum);
        //计算root左子树所有符合题意的路径个数（不包含root节点）
        sum+=pathSum(root.left,targetSum);
        //就是root右子树所有符合题意的路径个数
        sum+=pathSum(root.right,targetSum);

        return sum;
    }
    //在以node为根节点的二叉树中，寻找包含node节点的所有符合题意的路径个数
    private int findPath(TreeNode node, long targetSum) {
        if (node==null)
            return 0;
        int num=0;
        //判断当前节点是否满足题意：是---找到一个满足的，使个数加1，
        if (node.val==targetSum)
            num++;
        //可能在二叉树中出现负值，需要继续递归遍历判断
        num+=findPath(node.left,targetSum-node.val);
        num+=findPath(node.right,targetSum-node.val);
        return num;
    }
}
