package com.leetcode;

public class leetcode_1140 {

    public int stoneGameII(int[] piles) {

        int length = piles.length;
        int dp[][] = new int[length][length+1];

        int sum = 0;
        for (int i = length-1; i >=0 ; i--) {
            sum += piles[i];
            for (int m = 1; m < length+1; m++) {
                if(i+2*m>=length){
                    dp[i][m] = sum;
                }else{
                    for (int k = 1; k <= 2*m &&i+k<length; k++) {
                        dp[i][m] = Math.max(dp[i][m],sum-dp[i+k][Math.max(m,k)]);

                }


                }
            }
        }
        return dp[0][1];
    }

    public int countSum(int []piles,int s,int num){
        int ans = 0;
        for (int i = 0; i < num&&s<piles.length; i++) {
            ans +=piles[s];
            s++;
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_1140 demo = new leetcode_1140();
        demo.stoneGameII(new int[]{1});
    }
}
