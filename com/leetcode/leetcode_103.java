package com.leetcode;

import java.util.*;

public class leetcode_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int cur = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
                if(cur%2==0){
                    l.addLast(n.val);
                }else{
                    l.addFirst(n.val);
                }
            }
            cur ++;
            ans.add(l.stream().toList());
        }
        return ans;
    }
}
