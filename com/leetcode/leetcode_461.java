package com.leetcode;

public class leetcode_461 {

    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int ans = 0;
        while(temp!=0){
            ans++;
            temp = temp&(temp-1);
        }
        return ans;
    }
}
