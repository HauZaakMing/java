package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class leetcode_128 {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                if (!map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)) {
                    map.put(nums[i], nums[i]);
                } else if (map.containsKey(nums[i] - 1)&&map.containsKey(nums[i]+1)) {
                    int keyL = getRoot(nums[i]-1,map);
                    int keyR = getRoot(nums[i]+1,map);
                    map.put(nums[i],keyL);
                    map.put(keyR,keyL);
                } else if (!map.containsKey(nums[i] - 1)&&map.containsKey(nums[i]+1)) {
                    int keyR = getRoot(nums[i]+1,map);
                    map.put(nums[i],keyR);
                }else{
                    int keyL = getRoot(nums[i]-1,map);
                    map.put(nums[i],keyL);
                }
            }
        }
        Integer ans = 0;
        HashMap<Integer,Integer> count = new HashMap<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            int root = getRoot(value,map);
            int temp = count.getOrDefault(root,0)+1;
            count.put(root,temp);
            if(temp>ans){
                ans = temp;
            }
        }
        return ans;

    }

    public int getRoot(Integer key,HashMap<Integer,Integer> map){
        ArrayList<Integer> temp = new ArrayList<>();
        while (map.get(key)!=key){
            temp.add(key);
            key = map.get(key);
        }
        for (Integer num:
             temp) {
            map.put(num,key);
        }
        return key;
    }
}
