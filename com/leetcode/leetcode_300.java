package com.leetcode;

public class leetcode_300 {

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i-1; j >=0 ; j--) {
                if(nums[j]<nums[i]&&dp[j]>tmp){
                    tmp = dp[j];
                }
            }
            dp[i] = tmp+1;
            ans = Math.max(ans,tmp+1);
        }
        return ans;
    }
}
