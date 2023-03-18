package com.leetcode;

import java.util.Stack;

public class leetcode_42 {


    //用的动态规划
    public int trap1(int[] height) {
        int preTop = 0;
        int record = 0;

        int max_r[] = new int[height.length];
        int max_l[] = new int[height.length];
        //先求自己右边最高的墙
        for (int i = height.length-1; i >= 0 ; i--) {
            max_r[i] = record;
            record = Math.max(record,height[i]);
        }
        record = 0;
        for (int i = 0; i < height.length ; i++) {
            max_l[i] = record;
            record = Math.max(record,height[i]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(max_l[i],max_r[i]);
            if(min<=height[i]){
                continue;
            }else{
                ans+=min-height[i];
            }
        }
        return ans;
    }


    //要是用双指针来减少动态规划的空间消耗
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 1;
        for (int i = 1; i < height.length; i++) {
            if(height[i]>height[rightMax]){
                rightMax = i;
            }
        }

        int ans = 0;
        for (int i = 0; i < height.length-1; i++) {
            if(i==rightMax){
                rightMax = rightMax+1;
                int p = rightMax;
                while(p< height.length){
                    if(height[p]>height[rightMax]){
                        rightMax = p;
                    }
                    p++;
                }
                if(height[i]>height[leftMax]){
                    leftMax = i;
                }
                continue;
            }
            int min = Math.min(height[leftMax],height[rightMax]);
            if(height[i]<min){
                ans+=min-height[i];
            }
            if(height[i]>height[leftMax]){
                leftMax = i;
            }
        }
        return ans;
    }

}
