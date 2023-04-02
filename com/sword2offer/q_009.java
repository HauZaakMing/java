package com.sword2offer;

public class q_009 {
    //剑指 Offer II 009. 乘积小于 K 的子数组
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0){
            return 0;
        }
        long curP = 1;
        int p1 = 0;
        int p2 = 0;
        int ans = 0;
        while (p2<nums.length){
            curP = curP*nums[p2];
            while (curP>=k&&p1<p2){
                curP = curP/nums[p1];
                p1++;
            }
            if(p1==p2){
                if(nums[p2]>=k){
                    curP = curP/nums[p1];
                    p1 = p1+1;
                    p2 = p2+1;

                }else{
                    ans+=1;
                    p2++;
                }

            }else{
                ans+=(p2-p1+1);
                p2++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        q_009 demo = new q_009();
        demo.numSubarrayProductLessThanK(new int[]{100,2,3,4},100);
    }
}
