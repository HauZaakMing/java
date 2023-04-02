package com.sword2offer;

public class q_012 {
    //剑指 Offer II 012. 左右两边子数组的和相等
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int left = 0;
        int right = sum-nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if(left == right){
                return i;
            }else{
                left += nums[i];
                right -= nums[i+1];
            }
        }
        if(left == right){
            return nums.length-1;
        }
        return -1;



    }
}
