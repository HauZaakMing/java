package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode_2389 {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int []ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int curSum = 0;
            boolean flag = true;
            for (int j = 0; j < nums.length; j++) {
                curSum+=nums[j];
                if(curSum>queries[i]){
                    ans[i] = j;
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans[i] = nums.length;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_2389 demo = new leetcode_2389();
        demo.answerQueries(new int[]{736411,184882,914641,37925,214915},
        new int[]{331244,273144,118983,118252,305688,718089,665450});
    }
}
