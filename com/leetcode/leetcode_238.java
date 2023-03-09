package com.leetcode;

import java.util.Arrays;

public class leetcode_238 {

    public int[] productExceptSelf(int[] nums) {
        int curP = 1;
        int []ans = new int[nums.length];
        Arrays.fill(ans,1);
        for (int i = 0; i < nums.length; i++) {
            ans[i] = ans[i]*curP;
            curP = curP*nums[i];
        }
        curP =1;
        for (int i = nums.length-1; i >=0 ; i--) {
            ans[i] = ans[i]*curP;
            curP = curP*nums[i];
        }
        return ans;
    }
}
