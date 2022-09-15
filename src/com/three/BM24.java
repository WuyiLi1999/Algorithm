package com.three;


import java.util.ArrayList;
import java.util.Stack;

//BM24:二叉树的中序遍历
public class BM24 {
    //方案一：递归方法
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        if (root==null)
            return new int[0];
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        int [] arr=new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if (root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int[] inorderTraversal1 (TreeNode root) {
        // write code here
        if (root==null)
            return new int[0];
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.add(root);
        //1.优先判断树是否为null，树为null不进行遍历，直接出栈
        while(root!=null||!stack.empty()){
            //1.1：树不为null，遍历树的左子树，将节点依次加入栈中
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            //1.2：左子树为null（遍历到节点的最左边），保存该节点信息，访问该节点的右子树
            TreeNode node=stack.pop();
            list.add(node.val);
            root=node.right;
        }
        int [] arr=new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
}
