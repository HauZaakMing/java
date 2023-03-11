package com.leetcode;

import java.util.Stack;

public class leetcode_581 {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            int p1 = i;
            int p2 = nums.length-i-1;
            if(nums[p1]>=max){
                max = nums[p1];
            }else{
                right = p1;
            }
            if(nums[p2]<=min){
                min = nums[p2];
            }else{
                left = p2;
            }
        }
        return right!=-1?right-left+1:0;
    }
}
