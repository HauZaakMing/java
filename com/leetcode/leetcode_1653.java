package com.leetcode;

public class leetcode_1653 {

    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int countB = 0;

        for (int i = 0; i < s.length(); i++) {
            if(chars[i]=='a'){
                if(countB==0){
                    dp[i] = 0;
                }else{
                    dp[i] = Math.min(dp[i-1]+1,countB);
                }
            }else{
                if(i>0){
                    dp[i] = dp[i-1];
                }
                countB = countB+1;
            }
        }
        return dp[s.length()-1];
    }


    public static void main(String[] args) {
        leetcode_1653 demo = new leetcode_1653();
        demo.minimumDeletions("aababbab");
    }
}
