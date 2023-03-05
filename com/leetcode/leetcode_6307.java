package com.leetcode;

public class leetcode_6307 {
    public int passThePillow(int n, int time) {
        int t1 = time%(n-1);
        int t2 = time/(n-1);
        if(t2%2==0){
            return t1+1;
        }else{
            return n-t1;
        }
    }


}
