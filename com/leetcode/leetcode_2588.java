package com.leetcode;

import java.util.HashMap;

public class leetcode_2588 {

    public long beautifulSubarrays(int[] nums) {
        HashMap<Long,Integer> map = new HashMap<>();
        long key = 0;
        long ans = 0;
        map.put(0L,1);
        for (int i = 0; i < nums.length; i++) {
            key = key^nums[i];
            if(map.containsKey(key)){
                ans+=map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }

        }
        return ans;
    }


}
