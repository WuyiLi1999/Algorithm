package com.leetcode.BinaryTree_Recursion;

//450：删除二叉搜索树(BST)的节点
public class Test450_DeleteBSTNode {
    //时间复杂度和空间复杂度都为O(n)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)
            return root;
        //1、如果要删除的值小于节点值--要删除的节点一定在左子树中（在左子树中删除key）
        if (root.val>key){
            root.left=deleteNode(root.left,key);
            return root;
        }

        //2、如果要删除的值大于节点值--要删除的节点一定在右子树中（在有子树中删除key）
        if (root.val<key){
            root.right=deleteNode(root.right,key);
            return root;
        }

        //3、如果要删除的值等于节点值--找到要删除的节点
        if (root.val==key){
            //3.1、当前节点是叶子节点，直接返回null
            if (root.left==null&&root.right==null)
                return null;
            //3.2、当前节点只有右子树，返回该节点的右子树
            if (root.left==null)
                return root.right;
            //3.3、当前节点只有左子树，返回该节点的左子树
            if (root.right==null)
                return root.left;

            //3.4、当前节点左右子树都存在，寻找当前要删除节点的右子树中的最小值替换要删除的节点
            TreeNode node=root.right;
            while (node.left!=null)
                node=node.left;
            //删除当前要删除节点中的右子树的最小值，
            root.right=deleteNode(root.right,node.val);
            //删除节点的右子树的最小节点来代替要删除的节点的位置，最后返回出去，作为新的节点
            node.left=root.left;
            node.right=root.right;
            return node;
        }
        return root;
    }
}
