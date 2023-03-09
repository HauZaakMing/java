package com.leetcode;

public class leetcode_279 {
    public int numSquares(int n) {
        int []dp = new int[n+1];
        int[] squares = getSquares(100);
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            int min = Integer.MAX_VALUE;
            for (int s:
                 squares) {
                if(s>i){
                    break;
                }else{
                    min = (dp[i-s]+1)<min?dp[i-s]+1:min;
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static int[] getSquares(int maxFactor){
        int []squares = new int[maxFactor];
        for (int i = 1; i <= maxFactor ; i++) {
            squares[i-1] = i*i;
        }
        return squares;
    }

    public static void main(String[] args) {
        leetcode_279 demo = new leetcode_279();
        System.out.println(demo.numSquares(12));
    }
}
