package com.leetcode;

import java.util.Arrays;

public class leetcode_2587 {



    public int maxScore(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int p1 = 0;
        int p2 = nums.length-1;
        while(p1<p2){
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
        long cursum = 0;
        for (int i = 0; i < nums.length ; i++) {
            cursum += nums[i];
            if(cursum>0){
                ans = i+1;

            }else{
                break;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        leetcode_2587 demo = new leetcode_2587();
        demo.maxScore(new int[]{-687767,-860350,950296,52109,510127,545329,-291223,-966728,852403,828596,456730,-483632,-529386,356766,147293,572374,243605,931468,641668,494446});
    }
}
