package com.leetcode;

public class leetcode_64 {

    public int minPathSum(int[][] grid) {
        int [][]dp = new int[grid.length][grid[0].length];
        int l = grid.length;
        int w = grid[0].length;
        dp[0][0] = grid[0][0];
        for (int i = 1; i < l; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < w; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < l; i++) {
            for (int j = 1; j < w; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[l-1][w-1];
    }

    public static void main(String[] args) {
        leetcode_64 demo = new leetcode_64();
        demo.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }

}
