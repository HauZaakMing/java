package com.sword2offer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class q_26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A!=null&&B!=null){
            return findMatch(A,B);
        } else if (A==null&B==null) {
            return true;
        }else{
            return false;
        }
        //剑指 Offer 26. 树的子结构

    }

    public static boolean findMatch(TreeNode A, TreeNode B) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp.left!=null){
                queue.add(tmp.left);
            }
            if(tmp.right!=null){
                queue.add(tmp.right);
            }
            if (tmp.val == B.val) {
                if(check(tmp,B)){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean check(TreeNode A, TreeNode B) {
        boolean flag = true;
        if(B==null){
            return true;
        }
        if(A==null&&B!=null){
            return false;
        }

        flag = flag&&(A.val==B.val);
        flag = flag&&(check(A.left,B.left));
        flag = flag&&(check(A.right,B.right));
        return flag;
    }

    public static void main(String[] args) {
        q_26 demo = new q_26();
        demo.isSubStructure(new TreeNode(3,new TreeNode(4,new TreeNode(1),new TreeNode(2)),new TreeNode(5)),new TreeNode(4,new TreeNode(1),null));
    }
}
