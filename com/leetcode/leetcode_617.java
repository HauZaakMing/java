package com.leetcode;

import com.sun.source.tree.Tree;

public class leetcode_617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode left =null;
        TreeNode right =null;
        TreeNode temp =null;
        if(root1== null){
            return root2;
        }else if (root2==null){
            return root1;
        }else{
            left = mergeTrees(root1.left,root2.left);
            right = mergeTrees(root1.right,root2.right);
            temp = new TreeNode(root1.val+ root2.val,left,right);
        }

        return temp;




    }


}
