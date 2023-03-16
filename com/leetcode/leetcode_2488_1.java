package com.leetcode;

public class leetcode_2488_1 {

    public int countSubarrays(int[] nums, int k) {
        int pos = 0;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=k ){
                continue;
            }else{
                pos = i;
                break;
            }
        }
        int min = 0;
        int max = 0;
        int cur = 0;
        for (int i = pos-1; i >=0 ; i--) {
            if(nums[i]<k){
                cur--;
            }else{
                cur++;
            }
            if(cur==0||cur==1){
                ans++;
            }
            if(cur<min){
                min = cur;
            }
            if(cur>max){
                max = cur;
            }
        }
        cur = 0;
        int small_num = Math.abs(min);
        int big_num = Math.abs(max);
        for (int i = pos+1; i < nums.length ; i++) {
            if(nums[i]>k){
                cur++;
            }else{
                cur--;
            }
            if(cur == 0){
                ans++;
                if(big_num>0){
                    ans++;
                }
            }
            if(cur > 0){
                if(small_num>=cur){
                    ans+=2;
                } else if (small_num>=cur-1) {
                    ans+=1;
                }
            }
            if(cur<0){
                if(big_num+cur==0){
                    ans+=1;
                }else if(big_num+cur>0){
                    ans+=2;
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        leetcode_2488_1 demo = new leetcode_2488_1();
        demo.countSubarrays(new int[]{5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14},
        6);
    }
}
