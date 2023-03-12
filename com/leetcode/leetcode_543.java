package com.leetcode;

import java.util.HashMap;

public class leetcode_543 {
//    public HashMap<Integer,Integer> map = new HashMap<>();
//    public HashMap<Integer,Integer> max = new HashMap<>();
    public int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }


        getTreeHeight(root);


//        max.put(root.val,temp);
        return max;
    }

    public int getTreeHeight(TreeNode root){
        if(root==null){
            return 0;
        }



        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);
        int height = Math.max(left,right)+1;
        int temp = left+right;
        max = Math.max(max,temp);
        return height;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3));
        leetcode_543 demo = new leetcode_543();
        demo.diameterOfBinaryTree(root);
    }
}
