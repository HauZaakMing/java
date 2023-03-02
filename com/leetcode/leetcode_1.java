package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class leetcode_1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!m.containsKey(nums[i])) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                m.put(nums[i], l);
            } else {
                ArrayList<Integer> l = m.get(nums[i]);
                l.add(i);
                m.put(nums[i], l);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (temp != nums[i] && m.containsKey(temp)) {
                ans[0] = i;
                ans[1] = m.get(temp).get(0);
                break;
            } else if (temp == nums[i] && m.get(temp).size() > 1) {
                ans[0] = m.get(temp).get(0);
                ans[1] = m.get(temp).get(1);
                break;
            }
        }

        return ans;
    }
}
