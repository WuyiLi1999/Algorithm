package com.nowcoder.three;

import java.util.ArrayList;

//BM25：二叉树的后序遍历
public class BM25 {
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        if (root==null)
            return new int[0];
        ArrayList<Integer> lists=new ArrayList<>();
        postOrder(root,lists);
        int [] nums=new int[lists.size()];
        for (int i=0;i< lists.size();i++)
            nums[i]=lists.get(i);
        return nums;
    }
    public void postOrder(TreeNode root, ArrayList<Integer> lists){
        if(root==null)
            return;
        postOrder(root.left,lists);
        postOrder(root.right,lists);
        lists.add(root.val);
    }

}
