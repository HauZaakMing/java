package com.leetcode;

public class leetcode_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode leftReturn = null;
        TreeNode rightReturn = null;
        if(root.left!=null){
            leftReturn = lowestCommonAncestor(root.left,p,q);
        }
        if(root.right!=null){
            rightReturn = lowestCommonAncestor(root.right,p,q);
        }
        if(leftReturn!=null&&rightReturn!=null){
            return root;
        }
        if(leftReturn!=null){
            if(root.val==p.val||root.val==q.val){
                return root;
            }else{
                return leftReturn;
            }
        }
        if(rightReturn!=null){
            if(root.val==p.val||root.val==q.val){
                return root;
            }else{
                return rightReturn;
            }
        }
        if(root.val == p.val||root.val==q.val){
            return root;
        }
        return null;
    }




}
