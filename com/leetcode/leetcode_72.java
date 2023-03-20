package com.leetcode;

public class leetcode_72 {

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()];
        dp[0][0] = 0;
        for (int i = 1; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length()+1 ; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length()+1 ; i++) {
            for (int j = 1; j < word2.length()+1 ; j++) {
                //往A上插入
                int temp1 = dp[i-1][j]+1;
                //往B上插入
                int temp2 = dp[i][j-1]+1;
                //进行末位替换
                int temp3 = dp[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                dp[i][j] = Math.min(Math.min(temp1,temp2),temp3);
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        leetcode_72 demo = new leetcode_72();
        demo.minDistance("horse","ros");
    }
}
