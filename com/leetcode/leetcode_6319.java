package com.leetcode;

public class leetcode_6319 {

    public int[] evenOddBit(int n) {
        int []ans = new int[2];
        int count = 0;
        while(n>0){
            if(count%2==0){
                ans[0]+=n&1;
            }else{
                ans[1]+=n&1;
            }
            count++;
            n= n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_6319 demo = new leetcode_6319();
        demo.evenOddBit(2);
    }
}
