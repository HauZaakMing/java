package com.leetcode;

import java.util.HashMap;

public class leetcode_1_1 {


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curDiff = target-nums[i];
            if(map.containsKey(curDiff)){
                return new int[]{map.get(curDiff),i};
            }
            map.put(nums[i],i);

        }
        return null;
    }
}
