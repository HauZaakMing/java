package com.leetcode;

public class leetcode_1641 {

    //i 当前位置 j 当前选用的最大元音序
    int dp[][];
    public int countVowelStrings(int n) {
        dp = new int[n+1][5];
        int ans = dfs(0,0,n);
        return ans;
    }

    public int dfs(int pos,int curM,int n){
        if(pos==n){
            return 1;
        }
        if(dp[pos][curM]!=0){
            return dp[pos][curM];
        }
        int ans = 0;
        for (int i = curM; i < 5; i++) {
            ans +=dfs(pos+1,i,n);
        }
        dp[pos][curM] = ans;
        return ans;
    }
}
