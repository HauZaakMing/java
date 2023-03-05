package com.leetcode;

import java.util.Arrays;

public class leetcode_16 {


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length-2; i++) {
            int targetCur = target-nums[i];
            int p1 = i+1;
            int p2 = nums.length-1;
            if(targetCur<nums[i]){
                int distance = Math.abs(targetCur-nums[p1]-nums[p2]);
                if(distance<Math.abs(close-target)){
                    close = nums[i]+nums[p1]+nums[p2];
                }
                break;
            }

            while(p1!=p2){
                int distance = Math.abs(targetCur-nums[p1]-nums[p2]);
                if(distance==0){
                    return target;
                }
                if(distance<Math.abs(close-target)){
                    close = nums[i]+nums[p1]+nums[p2];
                }
                if(nums[p1]+nums[p2]>targetCur){
                    p2--;
                }else{
                    p1++;
                }
            }
        }
        return close;
    }

    public static void main(String[] args) {
        leetcode_16 demo = new leetcode_16();
        demo.threeSumClosest(new int[]{1,1,1,1},0);
    }

}
