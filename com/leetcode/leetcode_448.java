package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i])%(n+1)-1]+=(n+1);
        }

        for (int i = 0; i < n; i++) {
            if(nums[i]<(n+1)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
