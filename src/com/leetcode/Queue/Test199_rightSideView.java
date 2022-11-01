package com.leetcode.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//199:二叉树的右视图（返回从二叉树右边所能看到的从上到下的所有节点）
public class Test199_rightSideView {
    //二叉树的层序遍历，每一层的最右面就是我们所能看的元素
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root!=null)
            queue.add(root);
        //
        while (!queue.isEmpty()){
            int n=queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node=queue.poll();
                if (i==n-1)
                    list.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
        }
        return list;
    }
}
