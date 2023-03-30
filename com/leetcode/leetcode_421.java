package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode_421 {

    public int findMaximumXOR(int[] nums) {
        //用0,1前缀树
        TreeNode root = new TreeNode();
        //左是0，右是1
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(insertNum(root,nums[i]),ans);
        }
        return ans;
    }

    public int insertNum(TreeNode root,int num){
        //边插入边求该值能产生的最大值
        int ans = 0;
        TreeNode p1 = root;
        TreeNode p2 = root;
        for (int i = 31; i >= 0 ; i--) {
            int temp = (num>>i)&1;
            if(temp==0){
                if(p1.left==null){
                    p1.left = new TreeNode();
                }
                p1 = p1.left;
                if(p2.right!=null){
                    ans+=1<<i;
                    p2 = p2.right;
                }else{
                    p2 = p2.left;
                }

            }else{
                if(p1.right==null){
                    p1.right = new TreeNode();
                }
                p1 = p1.right;
                if(p2.left!=null){
                    ans+=1<<i;
                    p2 = p2.left;
                }else{
                    p2 = p2.right;
                }
            }


        }
        return ans;
    }


}
