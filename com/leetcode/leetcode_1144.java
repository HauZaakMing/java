package com.leetcode;

public class leetcode_1144 {

    public int movesToMakeZigzag(int[] nums) {
        int length = nums.length;

        // 一次遍历统计两种方案
        // 方案一 下降奇数位置,令偶数位置大
        // 方案二 下降偶数位置，令奇数位置大

        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 1) {
                // 开始对比左右
                int min = Integer.MAX_VALUE;
                if (i - 1 >= 0 && nums[i - 1] < min) {
                    min = nums[i - 1];
                }
                if (i + 1 < length && nums[i + 1] < min) {
                    min = nums[i + 1];
                }
                if (nums[i] >= min) {
                    ans1 += nums[i] - min + 1;
                }
            }

            if (i % 2 == 0) {
                // 开始对比左右
                int min = Integer.MAX_VALUE;
                if (i - 1 >= 0 && nums[i - 1] < min) {
                    min = nums[i - 1];
                }
                if (i + 1 < length && nums[i + 1] < min) {
                    min = nums[i + 1];
                }
                if (nums[i] >= min) {
                    ans2 += nums[i] - min + 1;
                }
            }
        }
        return ans1 < ans2 ? ans1 : ans2;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 4, 4, 10, 10, 6, 2, 3 };
        leetcode_1144 sol = new leetcode_1144();
        sol.movesToMakeZigzag(nums);
    }
}
