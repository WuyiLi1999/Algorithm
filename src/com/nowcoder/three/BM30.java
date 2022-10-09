package com.nowcoder.three;

//将一颗二叉搜索树转化为一个双向链表（二叉搜索树的中序遍历是递增有序的）
public class BM30 {
    //head为双向链表的头结点，返回的第一个指针，即为最小值，先定为null
    TreeNode head=null;
    //pre为中序遍历当前值的上一位，初值为最小值，先定为null
    TreeNode pre=null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        //中序递归：如果当前节点为null，返回null
        if (pRootOfTree==null)
            return null;
        //递归调用中序遍历左子树--直到左子树的叶子节点（头指针最小值）
        Convert(pRootOfTree.left);
        //找到最小值，对head和pre进行初始化
        if (pre==null){
            head=pRootOfTree;
            pre=pRootOfTree;
        }else {//如果不是最小值的话，当前节点与上一个节点之间建立连接，之后把当前节点设置为pre
            pre.right=pRootOfTree;
            pRootOfTree.left=pre;
            pre=pRootOfTree;
        }
        //递归调用中序遍历右子树
        Convert(pRootOfTree.right);
        return head;
    }
}
