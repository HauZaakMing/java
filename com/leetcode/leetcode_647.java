package com.leetcode;

import java.util.Arrays;

public class leetcode_647 {

    public int countSubstrings(String s) {
        s = s.replace("","*");
        int length = s.length();
        char[] chars = s.toCharArray();
        int []dp = new int[length];
        Arrays.fill(dp,1);
        for (int i = 0; i < length ; i++) {
            int p1 = i-dp[i];
            int p2 = i+dp[i];
            while(p1>=0&&p2<length){
                if(!(chars[p1]==chars[p2])){
                    break;
                }
                p1--;
                p2++;
            }
            dp[i] = p2-i;
            int p = p2;
            while((p--)>i){
                dp[p] = Math.min(p2-p,dp[2*i-p]);

            }
        }
        int ans = 0 ;
        for (int i = 1; i < length-1 ; i++) {
            if(i%2==1){
                ans += (dp[i]+1)/2;
            }else{
                ans += dp[i]/2;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_647 demo = new leetcode_647();
        demo.countSubstrings("aaa");
    }
}
