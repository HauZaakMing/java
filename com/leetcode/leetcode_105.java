package com.leetcode;

import java.util.Arrays;

public class leetcode_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildT(preorder,inorder);
    }

    public TreeNode buildT(int []pre,int []in){
        if(pre.length==0){
            return null;
        } else if (pre.length==1) {
            return new TreeNode(pre[0],null,null);
        } else{
            int root = pre[0];
            int p = 0;
            while (p<in.length){
                if(in[p]==root){
                    break;
                }
                p++;
            }
            int []newPre1 = Arrays.copyOfRange(pre,1,p+1);
            int []newIn1 = Arrays.copyOfRange(in,0,p);
            TreeNode left = buildT(newPre1,newIn1);
            int []newPre2 = Arrays.copyOfRange(pre,1+p,pre.length);
            int []newIn2 = Arrays.copyOfRange(in,p+1,pre.length);
            TreeNode right = buildT(newPre2,newIn2);
            return new TreeNode(root,left,right);
        }
    }
}
