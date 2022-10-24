package com.leetcode.BinaryTree_Recursion;

public class Test222_BinaryTreeCountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算二叉树的层数
        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        //根据完全二叉树的性质：最后一层叶子节点的所在数组中的位置在2^h-2^(h+1)-1
        int low = 1 << level;//左移运算符
        int high = (1 << (level + 1)) - 1;
        //根据节点个数范围的上下界得到当前需要判断的节点个数 k，如果第 k 个节点存在，则节点个数一定大于或等于 k，
        // 如果第 k 个节点不存在，则节点个数一定小于 k，由此可以将查找的范围缩小一半，直到得到节点个数
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    //判断二叉树第k个元素在第level层是否存在
    public boolean exists(TreeNode root, int level, int k) {
        //第 k 个节点位于第 h 层，则 k 的二进制表示包含 h+1 位，其中最高位是 1，其余各位从高到低表示从根节点到第 k 个节点的路径，
        // 0 表示移动到左子节点，1 表示移动到右子节点
        int bits = 1 << (level - 1);//表示第k个元素的二进制数的位数
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {//如果二进制的bits位=0--左子树，否则的话是右子树
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
