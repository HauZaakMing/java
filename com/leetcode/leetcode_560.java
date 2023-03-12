package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class leetcode_560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = 0;


        //pos0的前缀和为0
        map.put(0,1);
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];



            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }



        return ans;
    }
}
