package com.leetcode;

import com.sun.source.tree.Tree;

public class leetcode_538 {
    public static int cursum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        cursum = 0;
        convertBST1(root);
        return root;
    }

    public void convertBST1(TreeNode root){

        if(root.right!=null){
            convertBST1(root.right);
        }
        cursum += root.val;
        root.val = cursum;
        if(root.left!=null){
            convertBST1(root.left);
        }
        return ;
    }

    public static void main(String[] args) {
        leetcode_538 demo = new leetcode_538();
        demo.convertBST(new TreeNode(4,new TreeNode(1,new TreeNode(0),new TreeNode(2,null,new TreeNode(3))),new TreeNode(6,new TreeNode(5),new TreeNode(7,null,new TreeNode(8)))));
    }
}
