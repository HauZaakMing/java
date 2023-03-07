package com.leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode_94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }

    public static void inOrder(TreeNode root,ArrayList<Integer> ans){
        if(root==null){
            return ;
        }
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}
