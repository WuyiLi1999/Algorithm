package com.nowcoder.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//二叉树的层序遍历
public class BM26 {

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if (root==null)
            return null;
        //定义保存结果的一个列表
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        //定义一个队列用来保存每一层的节点
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //定义list集合来保存每一层的节点值
            ArrayList<Integer> list=new ArrayList<>();
            //当前层节点的个数
            int size=queue.size();
            //遍历当前层的所有节点
            for(int i=0;i<size;i++){
                //节点出队
                TreeNode node=queue.poll();
                //向列表中添加节点的值
                list.add(node.val);
                //将该节点的左右孩子节点添加到队列中作为下一层的节点
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right!=null)
                    queue.add(node.right);
            }
            //将当前层的节点信息保存到列表中
            lists.add(list);
        }
        return lists;
    }
}
