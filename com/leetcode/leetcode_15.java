package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int curNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == curNum) {
                continue;
            }
            curNum = nums[i];
            if (nums[i] > 0) {
                break;
            }
            if (nums[i] == 0) {
                if (map.get(0) >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(0);
                    temp.add(0);
                    temp.add(0);
                    ans.add(temp);
                    continue;
                } else {
                    continue;
                }

            }

            int curj = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] != curj) {
                    curj = nums[j];
                } else {
                    continue;
                }
                int target = 0 - nums[i] - nums[j];
                // 如果target位置跟i重合，不行
                if (target < nums[j]) {
                    continue;
                }
                if (map.containsKey(target)) {

                    if (target == nums[j] && map.get(nums[j]) < 2) {
                        continue;
                    }

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(target);
                    ans.add(temp);
                    continue;
                }

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_15 demo = new leetcode_15();
        demo.threeSum(new int[] { -1, 0, 1, 0 });
    }
}
