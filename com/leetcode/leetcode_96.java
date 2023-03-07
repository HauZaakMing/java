package com.leetcode;

public class leetcode_96 {

    public int numTrees(int n) {
        int []type = new int[n+1];
        type[0] = 1;
        type[1] = 1;

        return BSTtype(n,type);
    }

    public static int BSTtype(int n,int[] type){
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;
            if(type[i]!=0){
                left = type[i];
            }else{
                left = BSTtype(i,type);
                type[i] = left;
            }
            if(type[n-i-1]!=0){
                right = type[n-i-1];
            }else{
                right = BSTtype(n-i-1,type);
                type[n-i-1] = right;
            }
            ans += left*right;
        }
        return ans;
    }

}
