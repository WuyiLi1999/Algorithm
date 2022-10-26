package com.leetcode.BinaryTree_Recursion;

import java.util.ArrayList;
import java.util.List;

//113:寻找从根节点到叶子节点和为target的路径
public class Test113_PathSum {
    List<List<Integer>> lists=new ArrayList<>();//保存所有的路径
    List<Integer> list=new ArrayList<>();//保存从根节点到叶子节点和为target的一条路径

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //如果当前根节点为null，返回
        if (root==null)
            return lists;

        list.add(root.val);
        targetSum-=root.val;
        //当前节点为叶子节点并且到达叶子节点的目标和为等于0---找到一条路径
        if (root.left==null&&root.right==null&&targetSum==0){
            lists.add(new ArrayList<>(list));
        }
        //递归遍历寻找该节点的左子树是否存在一条路径满足
        pathSum(root.left,targetSum);
        //递归寻找该节点的右子树是否存在一条路径满足
        pathSum(root.right,targetSum);
        //如果没有的话，就移除当前节点
        list.remove(list.size()-1);
        return lists;
    }
}
