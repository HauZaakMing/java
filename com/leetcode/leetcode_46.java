package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_46 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean picked[];
    public List<List<Integer>> permute(int[] nums) {
        picked = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums,list);
        return ans;
    }

    public void dfs(int []nums, ArrayList<Integer> list){
        if(list.size()==nums.length){
            ans.add((List<Integer>) list.clone());
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(!picked[i]){
                    picked[i] =true;
                    list.add(nums[i]);
                    dfs(nums,list);
                    picked[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
