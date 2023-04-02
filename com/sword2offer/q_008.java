package com.sword2offer;

public class q_008 {
    //剑指 Offer II 008. 和大于等于 target 的最短子数组

    public int minSubArrayLen(int target, int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int curSum = 0;
        int ans = Integer.MAX_VALUE;
        while (p2<nums.length){
            curSum += nums[p2];
            while((curSum-nums[p1])>=target){

                curSum -= nums[p1];
                p1++;
            }
            if(curSum>=target){
                ans = Math.min(ans,p2-p1+1);
            }

            p2++;
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args) {
        q_008 demo = new q_008();
        demo.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
