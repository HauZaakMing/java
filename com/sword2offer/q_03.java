package com.sword2offer;

public class q_03 {


    public int[] countBits(int n) {
        if(n==0){
            return new int[]{0};
        } else if (n==1) {
            return new int[]{0,1};
        }
        int []dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int ans[] = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = (i&1)+dp[i>>1];
        }
        return dp;
    }
}
