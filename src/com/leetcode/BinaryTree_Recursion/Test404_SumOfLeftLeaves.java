package com.leetcode.BinaryTree_Recursion;

//404:左叶子节点之和--深度有点搜索遍历
public class Test404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        //如果当前节点为null，直接返回0
        if (root==null)
            return 0;
        //深度优先遍历计算左叶子节点之和
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        //保存左叶子节点之和
        int res=0;
        //如果当前节点的左节点不为null，判断左节点是否为叶子节点， 是--将节点对应的值加入到res中，不是--继续深度遍历左子树
        if (root.left!=null)
            if (isLeavesNode(root.left))//判断左节点是否为叶子节点
                res=res+root.left.val;//是--将节点对应的值加入到结果中
            else
                res+=dfs(root.left);//不是--继续深度优先遍历左子树
        //如果当前节点的右节点不为null，并且右节点不是叶子节点--深度优先遍历右子树
        if (root.right!=null&&!isLeavesNode(root.right))
            res+=dfs(root.right);
        //返回结果
        return res;
    }
    //判断当前节点是否为叶子节点
    private boolean isLeavesNode(TreeNode node) {
        return node.left==null&&node.right==null;
    }
}
