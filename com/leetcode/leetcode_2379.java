package com.leetcode;

public class leetcode_2379 {
    public int minimumRecolors(String blocks, int k) {
        int length = blocks.length();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if(blocks.charAt(i)=='W'){
                count++;
            }
        }
        int min = count;
        for (int i = k; i < length; i++) {
            if(blocks.charAt(i-k)=='W'){
                count = count-1;
            }
            if(blocks.charAt(i)=='W'){
                count = count+1;
            }
            if(count<min){
                min = count;
            }
        }
        return min;
    }
}
