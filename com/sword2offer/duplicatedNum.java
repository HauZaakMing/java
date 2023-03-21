package com.sword2offer;

import java.util.HashSet;

public class duplicatedNum {
    //剑指 Offer 03. 数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
//        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return nums[i];
            }else{
                set.add(nums[i]);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        duplicatedNum demo = new duplicatedNum();
        demo.findRepeatNumber(new int[]{2,3,1,0,2,5,3});
    }
}
