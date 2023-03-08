package com.leetcode;

public class leetcode_152 {
    //dp 得学会考虑多种状态，并不局限在一种上
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if(length ==1){
            return nums[0];
        }
//        long dpMax = new long[length];
//        long dpMin = new long[length];
        long preMax = nums[0];
        long preMin = nums[0];
        long ans = nums[0];
        for (int i = 1; i < length; i++) {

            long curMax = Math.max(preMax*nums[i],Math.max(preMin*nums[i],nums[i]));
            long curMin = Math.min(preMax*nums[i],Math.min(preMin*nums[i],nums[i]));
            if(curMax>ans){
                ans = curMax;
            }
            preMax = curMax;
            preMin = curMin;
        }
        return (int)(ans);
    }

    public static void main(String[] args) {
        leetcode_152 demo = new leetcode_152();
        demo.maxProduct(new int[]{2,3,-2,4});
    }
}
