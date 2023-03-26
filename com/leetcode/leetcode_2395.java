package com.leetcode;

import java.util.HashSet;

public class leetcode_2395 {

    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> sum = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            int temp = nums[i]+nums[i+1];
            if(sum.contains(temp)){
                return true;
            }else{
                sum.add(temp);
            }
        }
        return false;
    }
}
