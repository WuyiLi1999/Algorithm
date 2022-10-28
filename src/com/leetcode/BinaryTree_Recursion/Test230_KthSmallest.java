package com.leetcode.BinaryTree_Recursion;

import java.util.Stack;

//230:二叉搜索树第K小的元素
public class Test230_KthSmallest {
    //中序遍历（二叉搜索树中序遍历是一个递增有序序列）,
    public int kthSmallest(TreeNode root, int k){
        //当前节点为null返回-1，节点不存在元素
        if (root==null)
            return -1;
        //栈的后进先出特性可以进行中根序遍历
        Stack<TreeNode> stack=new Stack<>();

        while (!stack.empty()||root!=null){
            //遍历BST的当前节点最左子树，直到根节点，依次将元素添加到栈中
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            //出栈
            root=stack.pop();
            k--;
            if (k==0)//真名找到了第K小的元素
                break;
            //遍历当前节点的右子树
            root=root.right;
        }
        return root.val;
    }

}
