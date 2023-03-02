package com.leetcode;

import java.util.Arrays;

public class leetcode_2576 {

    public int maxNumOfMarkedIndices(int[] nums) {

        Arrays.sort(nums);
        int p = nums.length / 2 - 1;

        int p2 = nums.length - 1;
        int ans = 0;
        while (p >= 0 && p2 > nums.length / 2 - 1) {
            if (nums[p2] >= nums[p] * 2) {

                ans++;
                p2--;
                p--;

            } else {
                p--;
            }
        }

        return ans * 2;
    }

    public static void main(String[] args) {
        leetcode_2576 demo = new leetcode_2576();
        int[] nums = { 42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29,
                15, 40 };
        demo.maxNumOfMarkedIndices(nums);
    }

}
