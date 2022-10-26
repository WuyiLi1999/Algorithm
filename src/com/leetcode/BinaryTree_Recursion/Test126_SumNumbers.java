package com.leetcode.BinaryTree_Recursion;

import java.util.ArrayList;
import java.util.List;

//129:求根节点到叶子节点的所生成的所有的数字之和
public class Test126_SumNumbers {
    List<String> list=new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;
        Numbers(root,"");
        int number=0;
        for (int i = 0; i < list.size(); i++) {
            number+=Integer.parseInt(list.get(i));
        }
        return number;
    }

    private void Numbers(TreeNode root, String s) {
        if (root==null)
            return;
        StringBuffer buffer=new StringBuffer(s);
        buffer.append(root.val);
        if (root.left==null&&root.right==null)
            list.add(buffer.toString());
        Numbers(root.left,buffer.toString());
        Numbers(root.right,buffer.toString());
    }
    //方法二：深度优先遍历
    public int sumNumbers_Dfs(TreeNode root) {
        //如果当前节点为null--返回0
        if (root==null)
            return 0;
        //进行深度优先遍历计算根节点到叶子节点的所生成的所有的数字之和
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int preNum) {
        //当前节点为null--不存在从根节点到该节点的路径，返回0
        if (root==null)
            return 0;
        //计算从根节点到该节点所对应的数字
        int curNum=preNum*10+root.val;
        //递归结束条件：当前节点为null--找到一个从根节点到叶子节点的一个组成数字，返回出去
        if (root.left==null&&root.right==null)
            return curNum;
        //如果当前节点不是叶子节点--深度优先遍历左右子树，将左右子树寻找到的路径组成数字加在一起
        return dfs(root.left,curNum)+dfs(root.right,curNum);
    }

}
