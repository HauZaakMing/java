package com.leetcode;

import java.util.HashMap;

public class leetcode_337 {
    HashMap<TreeNode,Integer> maxP = new HashMap<>();
    public int rob(TreeNode root) {

        if(root==null){
            return 0;
        }

        return max(root);

    }

    public int max(TreeNode root){
        int sum1 = root.val;
        if(root.left!=null){
            if(root.left.left!=null){
                sum1+=getMax(root.left.left);
                }
            if(root.left.right!=null){
                sum1 +=getMax(root.left.right);
            }
        }

        if(root.right!=null){
            if(root.right.left!=null){
                sum1+= getMax(root.right.left);
            }
            if(root.right.right!=null){
                sum1+= getMax(root.right.right);
            }
        }
        int sum2 = 0;
        if(root.left!=null){
            sum2 += getMax(root.left);
        }
        if(root.right!=null){
            sum2 += getMax(root.right);
        }
        return sum1>sum2?sum1:sum2;
    }

    public int getMax(TreeNode node){
        if(maxP.containsKey(node)){
            return maxP.get(node);
        }else{
            int temp1 = max(node);
            maxP.put(node,temp1);
            return temp1;
        }
    }

    public static void main(String[] args) {

    }
}
