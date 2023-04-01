package com.leetcode;

import java.util.HashSet;

public class leetcode_2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]-diff)&&set.contains(nums[i]-diff-diff)){
                ans++;
            }

            set.add(nums[i]);
        }
        return ans;
    }
}
