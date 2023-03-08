package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class leetcode_139 {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        Integer [][]dp = new Integer[s.length()][s.length()];
        for (Integer []temp:
             dp) {
            Arrays.fill(temp,-1);
        }
        return wordSearch(s,0,s.length()-1,dp);


    }

    public boolean wordSearch(String s,int left,int right,Integer [][]dp){
        if(dp[left][right]!=-1){
            return dp[left][right]==1;
        }
        String str = s.substring(left,right+1);
        if(set.contains(str)){
            return true;
        }
        for (int i = left; i <right ; i++) {
            boolean leftOK = wordSearch(s,left,i,dp);
            boolean rightOK = wordSearch(s,i+1,right,dp);
            if(leftOK&&rightOK){
                dp[left][right]=1;
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        leetcode_139 demo = new leetcode_139();

    }
}
