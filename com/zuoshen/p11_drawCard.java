package com.zuoshen;

public class p11_drawCard {

    public static int firstHand(int[] cards, int[][] dp, int start, int end) {
        if (end - start == 1) {
            return cards[start] > cards[end] ? cards[start] : cards[end];
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        // 取左侧
        int Lmax = cards[start] + sumA(cards, start + 1, end) - firstHand(cards, dp, start + 1, end);
        int Rmax = cards[end] + sumA(cards, start, end - 1) - firstHand(cards, dp, start, end - 1);
        dp[start][end] = Math.max(Lmax, Rmax);
        return dp[start][end];
    }

    public static int sumA(int[] nums, int s, int e) {
        int ans = 0;
        for (int i = s; i <= e; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

        // List<Integer> cards = Arrays.asList(1, 4, 5, 100, 7, 6);
        int[] cards = { 1, 100, 2 };

        int[][] dp = new int[cards.length][cards.length];
        int f = firstHand(cards, dp, 0, cards.length - 1);
        if (sumA(cards, 0, cards.length - 1) - f > f) {
            System.out.println(sumA(cards, 0, cards.length - 1) - f);
        } else {
            System.out.println(f);
        }
        System.out.println();
        System.out.println();
    }
}
