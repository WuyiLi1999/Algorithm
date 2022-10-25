package com.leetcode.BinaryTree_Recursion;

import java.util.ArrayList;
import java.util.List;

//257：二叉树的所有路径--深度有点遍历
public class Test257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root){
        List<String> list=new ArrayList<>();//保存当前节点的路径
        if (root==null)//如果当前节点为null，直接返回
            return list;
        //递归结束条件：当前节点为叶子节点：将当前节点值加入到list中（当前节点的路径）
        if (root.left==null&&root.right==null){
            list.add(String.valueOf(root.val));
            return list;
        }
        //深度遍历左子树的路径
        List<String> leftList=binaryTreePaths(root.left);
        for (int i = 0; i < leftList.size(); i++) {
            list.add(String.valueOf(root.val)+"->"+leftList.get(i));//将左子树的所有路径添加到list集合中
        }
        //深度优先遍历右子树的路径
        List<String> rightList=binaryTreePaths(root.right);
        for (int i = 0; i < rightList.size(); i++) {
            list.add(String.valueOf(root.val)+"->"+rightList.get(i));//将右子树的所有路径添加到list集合中
        }

        return list;
    }
}
