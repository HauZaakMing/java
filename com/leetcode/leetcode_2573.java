package com.leetcode;

public class leetcode_2573 {
    public static final int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 },
            { 1, 0 }, { 1, 1 } };

    public int[][] largestLocal(int[][] grid) {
        int l = grid.length;
        int[][] ans = new int[l - 2][l - 2];
        for (int i = 1; i < l - 1; i++) {
            for (int j = 1; j < l - 1; j++) {
                ans[i - 1][j - 1] = getMax(grid, i, j);
            }
        }
        return ans;
    }

    public int getMax(int[][] grid, int x, int y) {
        int max = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (grid[nx][ny] > max) {
                max = grid[nx][ny];
            }
        }
        return max;
    }
}
