package com.sword2offer;

import java.util.LinkedList;
import java.util.Queue;

public class q_045 {
    //剑指 Offer II 045. 二叉树最底层最左边的值
    public int findBottomLeftValue(TreeNode root) {
        int ans=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                if(i==0){
                    ans = node.val;
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }

}
