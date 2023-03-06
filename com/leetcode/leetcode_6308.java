package com.leetcode;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_6308 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Long> sums = new PriorityQueue<>((o1, o2) ->  o2>o1?1:-1);
        if(k==0){
            return root.val;
        }else{
            queue.add(root);
        }
        long ans_cur = 0;
        while(queue.size()!=0){
            ans_cur = 0;
            int times = queue.size();
            while(times-->0){
                TreeNode temp = queue.poll();
                ans_cur += temp.val;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!= null){
                    queue.add(temp.right);
                }
            }
            sums.add(ans_cur);
        }

        if(sums.size()<k){
            return -1;
        }
        while(--k>0){
            sums.poll();
        }
        return sums.poll();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(8,new TreeNode(2,null,null),new TreeNode(1,null,null)),new TreeNode(9,new TreeNode(3,null,null),new TreeNode(7,null,null)));

        leetcode_6308 demo = new leetcode_6308();
        System.out.println(demo.kthLargestLevelSum(root,4));
    }
}
