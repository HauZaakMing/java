package com.leetcode;

import java.util.ArrayList;

public class leetcode_309 {

    public int maxProfit(int[] prices) {
        int dp[] = new int[prices.length+2];

        dp[prices.length-1] = 0;
        for (int i = prices.length-2; i >=0 ; i--) {
            //选择不买
            dp[i] = Math.max(dp[i],dp[i+1]);
            //选择买,然后选择一天拿去卖
            for (int j = i+1; j <prices.length ; j++) {
                int profit = -prices[i]+prices[j]+dp[j+2];
                dp[i] = Math.max(profit,dp[i]);
            }

        }

        return dp[0];
    }
}
