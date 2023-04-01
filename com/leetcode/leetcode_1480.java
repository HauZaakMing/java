package com.leetcode;

public class leetcode_1480 {

    public int[] runningSum(int[] nums) {
        int []ans = new int[nums.length];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum+=nums[i];
            ans[i] = curSum;
        }
        return ans;
    }
}
