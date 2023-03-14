package com.leetcode;

import java.util.Arrays;

public class leetcode_416 {
    boolean check[][] = new boolean[201][20001];
    public boolean canPartition1(int[] nums) {
        for (boolean[] subcheck:
             check) {
            Arrays.fill(subcheck,true);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum >> 1;
        return dfs(nums, target, 0);
    }





    public boolean dfs(int[] nums, int target, int pos) {
        if(pos==nums.length){
            return false;
        }

        //要nums[pos]
        int curtarget = target - nums[pos];
        if(curtarget==0){
            return true;
        } else if (curtarget>0) {
            if(!check[pos+1][curtarget]){

            }else{
                boolean flag = dfs(nums,curtarget,pos+1);
                if(flag){
                    return true;
                }else{
                    check[pos+1][curtarget] = false;
                }
            }

        }
        //不要nums[pos]
        if(!check[pos+1][target]){

        }else{
            boolean flag = dfs(nums,target,pos+1);
            if(flag){
                return true;
            }else{
                check[pos+1][target] = false;
            }
        }
        return false;
    }
}
