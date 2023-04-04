package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode_1000 {
    // 这个题目用区间DP+前缀和

    private int[][] memo;
    private int[] s;
    private int k;

    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) > 0) // 无法合并成一堆
            return -1;

        s = new int[n + 1];
        for (int i = 0; i < n; i++)
            s[i + 1] = s[i] + stones[i]; // 前缀和
        this.k = k;
        memo = new int[n][n];
        for (int i = 0; i < n; ++i)
            Arrays.fill(memo[i], -1); // -1 表示还没有计算过
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i == j) return 0; // 只有一堆石头，无需合并
        if (memo[i][j] != -1) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1)
            res = Math.min(res, dfs(i, m) + dfs(m + 1, j));
        if ((j - i) % (k - 1) == 0) // 可以合并成一堆
            res += s[j + 1] - s[i];
        return memo[i][j] = res;
    }



    public static void main(String[] args) {
        leetcode_1000 demo = new leetcode_1000();
        demo.mergeStones(new int[]{3,5,1,2,6},3);
        System.out.println(1);
    }


}
