package com.leetcode;

public class leetcode_2574 {
    public int[] leftRigthDifference(int[] nums) {

        int[] ans = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int l = 0;
        int r = sum - nums[0];
        for (int i = 0; i < ans.length - 1; i++) {
            ans[i] += Math.abs(r - l);
            l = l + nums[i];
            r = r - nums[i + 1];
        }
        ans[ans.length - 1] = sum - nums[ans.length - 1];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1 };
        leetcode_2574 demo = new leetcode_2574();
        demo.leftRigthDifference(nums);
    }
}
