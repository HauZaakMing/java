package com.leetcode;

import java.util.HashMap;

public class leetcode_525 {

    public int findMaxLength(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        map.put(0,0);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                count++;
            }else{
                count--;
            }
            if(!map.containsKey(count)){
                map.put(count,i+1);
            }
            if(map.containsKey(count)){
                ans = Math.max(ans,i+1-map.get(count));
            }
        }
        return ans;
    }
}
