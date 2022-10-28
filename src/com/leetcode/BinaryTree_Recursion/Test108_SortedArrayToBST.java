package com.leetcode.BinaryTree_Recursion;

//108:将一个有序数组转变为高度平衡的二叉搜索树(BST)
public class Test108_SortedArrayToBST {
    //二叉搜索树的中根序遍历是有序递增的，
    //方案一：中序遍历，总是选择中间位置左边的数字作为根节点  时间复杂度O(n)，空间复杂度O(logn)
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=new TreeNode();
        if(nums==null||nums.length==0)
            return root;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        //递归结束条件：当数组元素的起始位置大于终止位置的时候（不在存在元素），直接返回null
        if (start>end)
            return null;
        //总是选择中间位置左边的数字作为根节点
        int mid=(end-start)/2+start;
        TreeNode node=new TreeNode(nums[mid]);
        //递归遍历，确定当前节点的左子树的根节点
        node.left=sortedArrayToBST(nums,start,mid-1);
        //递归遍历，确定当前节点的右子树的根节点
        node.right=sortedArrayToBST(nums,mid+1,end);
        return node;
    }

}
