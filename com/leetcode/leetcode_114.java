package com.leetcode;

public class leetcode_114 {

    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatT(root);
    }

    public static TreeNode flatT(TreeNode root){
        //需要末位节点
        TreeNode leftL = null;
        TreeNode rightL =null;
        if(root.left==null&&root.right==null){
            return root;
        }

        if(root.left!=null){
            leftL = flatT(root.left);
        }
        if(root.right!=null){
            rightL = flatT(root.right);
        }

        if(root.left!=null&&root.right!=null){

            leftL.right= root.right;
            root.right = root.left;
            root.left = null;
            return rightL;
        }
        if(root.left==null&&root.right!=null){
            return rightL;
        }
        if(root.left!=null&&root.right==null){
            root.right = root.left;
            root.left = null;
            return leftL;
        }
        return null;
    }

    public static void main(String[] args) {
        leetcode_114 demo = new leetcode_114();
        demo.flatten(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,null,new TreeNode(6))));
    }
}
