package com.nowcoder.three;

//两个二叉树的合并，
// 合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
public class BM32 {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1==null&&t2==null)
            return null;
        else
            return mergeNode(t1,t2);

    }
    public TreeNode mergeNode (TreeNode t1, TreeNode t2){
        if (t1==null&&t2==null)
            return null;
        if (t1==null||t2==null)
            return t1==null?t2:t1;
        else{
            t1.left=mergeNode(t1.left,t2.left);
            t1.right=mergeNode(t1.right,t2.right);
            t1.val=t1.val+t2.val;
            return t1;
        }
    }

    public TreeNode mergeTrees_1 (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1==null&&t2==null)
            return null;
        if (t1==null||t2==null)
            return t1==null?t2:t1;
        else {
            t1.left=mergeTrees_1(t1.left,t2.left);
            t1.right=mergeTrees_1(t1.right,t2.right);
            t1.val=t1.val+t2.val;
            return t1;
        }

    }
}
