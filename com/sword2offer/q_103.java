package com.sword2offer;

import java.util.Arrays;

public class q_103 {
    //剑指 Offer II 103. 最少的硬币数目
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int dp[] = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            dp[i] = Integer.MAX_VALUE/2;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount+1 ; j++) {

                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);

            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        q_103 demo = new q_103();
        demo.coinChange(new int[]{186,419,83,408},6249);
    }
}
