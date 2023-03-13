package com.leetcode;

public class leetcode_53 {

    public int maxSubArray(int[] nums) {
        int dp = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(dp<0){
                dp = nums[i];
                if(dp>max){
                    max = dp;
                }
                continue;
            }
            dp += nums[i];
            if(dp>max){
                max = dp;
            }
        }
        return max;
    }
}
