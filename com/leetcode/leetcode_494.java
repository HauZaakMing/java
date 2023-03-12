package com.leetcode;

import java.lang.annotation.Target;

public class leetcode_494 {
    public int ans = 0;
    public int findTargetSumWays1(int[] nums, int target) {
        int length =nums.length;
        int ans=0;
        //记录特定状态位的值
        int dp[][] = new int[nums.length][];
        for (int i = 0; i < (1<<length); i++) {
            int temp = i;
            int sum = 0;
            for (int j = 0; j < length; j++) {
                if((temp&1)==1){
                    sum+=nums[j];
                }else{
                    sum-=nums[j];
                }
                temp=temp>>1;
            }
            if(sum==target){
                ans++;
            }
        }
        return ans;
    }

    public int findTargetSumWays2(int[] nums, int target) {
        find(nums,target,0,0);
        return ans;
    }

    public void find(int []nums,int target, int pos,int sum){
        if(pos ==nums.length){
            if(sum==target){
                ans++;
            }


        }else{
            find(nums,target,pos+1,sum+nums[pos]);
            find(nums,target,pos+1,sum-nums[pos]);
        }

    }

    public int findTargetSumWays(int []nums, int target){
        int sum = 0;
        for (int num :
                nums) {
            sum+=num;
        }
        if(sum-target<0||(sum-target)%2==1){
            return 0;
        }
        int negative = (sum-target)/2;
        int dp[][] = new int[nums.length+1][negative+1];
        dp[0][0] = 1;
        for (int i = 1; i < negative+1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 0; j < negative+1; j++) {
                //pick nums[i-1]
                if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }
            }
        }
        return dp[nums.length][negative];
    }
}
