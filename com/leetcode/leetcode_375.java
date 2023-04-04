package com.leetcode;

import java.net.Inet4Address;
import java.util.Arrays;

public class leetcode_375 {
    public int dp[][];

    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 1; i < n + 1; i++) {
            dp[i][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = i;
        }
        for (int i = 1; i < n - 1; i++) {
            dp[i][i + 2] = i + 1;
        }
        return dfs(1,n);

    }

    public int dfs(int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i+1 ; k < j ; k++) {
            int cost = k+Math.max(dfs(i,k-1),dfs(k+1,j));
            if(cost<min){
                min = cost;
            }
        }
        dp[i][j] = min;
        return min;

    }
}
