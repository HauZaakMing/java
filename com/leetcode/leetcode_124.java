package com.leetcode;

public class leetcode_124 {
    public static int ans;
    public int maxPathSum(TreeNode root) {
        //查找左右子树的最大路径
        //接上，加上根节点，去比较最值
        //向上传递当前最长节点路径加上根节点的值
        ans = Integer.MIN_VALUE;
        findMax(root);
        return ans;
    }


    public int findMax(TreeNode root){
        int leftLen = 0;
        int rightLen = 0;
        if(root.left!=null){
            leftLen = findMax(root.left);
        }
        if(root.right!=null){
            rightLen = findMax(root.right);
        }
        if(leftLen+rightLen+root.val>ans){
            ans = leftLen+rightLen+root.val;
        }
        if(leftLen+root.val>ans){
            ans = leftLen+ root.val;
        }
        if(rightLen+ root.val>ans){
            ans = rightLen+root.val;
        }
        if(root.val>ans){
            ans = root.val;
        }
        return Math.max(Math.max(leftLen,rightLen),0)+root.val;
    }
}
