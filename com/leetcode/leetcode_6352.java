package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class leetcode_6352 {
    public static int ans;
    public static HashMap<Integer,Integer> map = new HashMap<>();

    //dfs查找可行的美丽子集
    //用一个HashMap记录当前禁止进入的数字
    public int beautifulSubsets(int[] nums, int k) {
        ans = 0;
        for (int i = -1000; i < 2000 ; i++) {
            map.put(i,0);
        }
        dfs(nums,k,0);
        return ans;
    }

    private void dfs(int[] nums, int k, int pos) {
        if(pos == nums.length){
            return;
        }
        //pos go

        if(map.get(nums[pos])==0){
            ans++;
            map.put(nums[pos]-k,map.get(nums[pos]-k)+1);
            map.put(nums[pos]+k,map.get(nums[pos]+k)+1);
            dfs(nums,k,pos+1);
            map.put(nums[pos]-k,map.get(nums[pos]-k)-1);
            map.put(nums[pos]+k,map.get(nums[pos]+k)-1);
            dfs(nums,k,pos+1);
        }else{
            dfs(nums,k,pos+1);
        }


    }

    public static void main(String[] args) {
        leetcode_6352 demo = new leetcode_6352();
        demo.beautifulSubsets(new int[]{9,5,7,10,6,2},9);
    }


}