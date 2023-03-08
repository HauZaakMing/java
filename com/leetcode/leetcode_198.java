package com.leetcode;

public class leetcode_198 {

    public int rob(int[] nums) {

        int ans = 0;
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int dp_1 = Math.max(nums[0], nums[1]);
            int dp_2 = nums[0];
            for (int i = 2; i < nums.length; i++) {
                int curMax = Math.max(dp_2 + nums[i], dp_1);
                if (curMax > ans) {
                    ans = curMax;
                }
                dp_2 = dp_1;
                dp_1 = curMax;
            }
        }
        return ans;
    }
}
