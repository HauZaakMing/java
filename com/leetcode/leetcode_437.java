package com.leetcode;

import java.util.HashMap;

public class leetcode_437 {
    HashMap<Long,Integer> map = new HashMap<>();
    public int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        map.put(0L,1);
        dfs(root,targetSum,0);



        return ans;
    }

    public void dfs(TreeNode root, long targetSum ,long pre) {

        if(root == null){
            return ;
        }
        pre += root.val;
        if(map.containsKey(pre-targetSum)){
            ans+=map.get(pre-targetSum);
        }
        map.put(pre,map.getOrDefault(pre,0)+1);
        dfs(root.left,targetSum,pre);
        dfs(root.right,targetSum,pre);
        map.put(pre,map.getOrDefault(pre,0)-1);


        return ;
    }

    public static void main(String[] args) {
        TreeNode root = tools.String2BTree("1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000");
        leetcode_437 demo = new leetcode_437();
        System.out.println(demo.pathSum(root, 0));
    }

}
