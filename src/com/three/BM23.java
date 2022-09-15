package com.three;

import com.One.ListNode;

import java.util.ArrayList;
import java.util.Stack;

//BM23:二叉树的前序遍历
public class BM23 {
    //方案一：递归
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> list=new ArrayList<>();
        preOrder(list,root);
        int [] arr=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
    public void preOrder(ArrayList<Integer> list,TreeNode root){
        if(root==null)
            return;
        list.add(root.val);
        preOrder(list,root.left);
        preOrder(list,root.right);
    }
    //方案二：通过一个栈数据结构来实现
    public int[] preorderTraversal1 (TreeNode root) {
        // write code here
        ArrayList<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null)
            return new int[0];
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);
            if (node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
        int [] arr=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i]=list.get(i);
        }
        return arr;
    }
}
