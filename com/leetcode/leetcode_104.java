package com.leetcode;

public class leetcode_104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return maxTreeD(root);
    }

    public static int maxTreeD(TreeNode root){

        if(root.left==null&&root.right==null){
            return 1;
        }else{
            int left = 0;
            int right =0;
            if(root.left!=null){
                left = maxTreeD(root.left);
            }
            if(root.right!=null){
                right = maxTreeD(root.right);
            }
            return Math.max(left,right)+1;
        }
    }

}
