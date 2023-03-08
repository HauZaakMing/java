package com.leetcode;

public class leetcode_114 {

    public void flatten(TreeNode root) {

    }

    public static TreeNode flatT(TreeNode root){
        //需要末位节点
        TreeNode leftL = null;
        TreeNode rightL =null;
        if(root.left!=null){
            leftL = flatT(root.left);
        }
        if(root.right!=null){
            rightL = flatT(root.right);
        }
        if(leftL!=null){

        }
        return null;
    }
}
