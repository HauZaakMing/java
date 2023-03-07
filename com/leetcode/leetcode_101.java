package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_101 {

    public boolean isSymmetric(TreeNode root) {
        if(root.left==null&&root.right==null){
            return true;
        }
        if(!(root.left!=null&&root.right!=null)){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root.left);
        queue2.add(root.right);
        while((!queue1.isEmpty())&&(!queue2.isEmpty())){
            TreeNode l = queue1.poll();
            TreeNode r = queue2.poll();
            if(l.val!=r.val){
                return false;
            }else{
                if((l.left!=null)&&(r.right!=null)){
                    queue1.add(l.left);
                    queue2.add(r.right);
                }else if((l.left==null)&&(r.right==null)){

                }else{
                    return false;
                }
                if((l.right!=null)&&(r.left!=null)){
                    queue1.add(l.right);
                    queue2.add(r.left);
                } else if ((l.right == null) && (r.left == null)) {

                }else{
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        leetcode_101 demo = new leetcode_101();
        demo.isSymmetric(new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(4),new TreeNode(3))));
    }
}
