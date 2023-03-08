package com.sword2offer;

public class q_47 {

    public int maxValue(int[][] grid) {
        int l = grid.length;
        int w = grid[0].length;
        int[][] dp = new int[l][w];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < l; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < w; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < l; i++) {
            for (int j = 1; j < w; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[l-1][w-1];

    }

    public static void main(String[] args) {
        q_47 demo = new q_47();
        demo.maxValue(new int[][]{{1,2,5},{3,2,1}});
    }
}
