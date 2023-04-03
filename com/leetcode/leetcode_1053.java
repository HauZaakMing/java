package com.leetcode;

import java.util.Arrays;

public class leetcode_1053 {

    public int[] prevPermOpt1(int[] arr) {
        int []copy = arr.clone();
        Arrays.sort(copy);
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if(copy[i]!=arr[i]){
                flag = false;
                break;
            }
        }
        if(flag){
            return arr;
        }
        int pos = 0;
        for (int i = arr.length-2; i >=0 ; i--) {
            if(arr[i]>arr[i+1]){
                pos = i;
                break;
            }
        }
        //找比pos上的数值小但是最大的，且最靠近pos的
        int p2 = pos+1;
        for (int i = pos+1; i <arr.length ; i++) {

            if(arr[i]<arr[pos]&&arr[i]>arr[p2]){
                p2 = i;
//                Arrays.sort(arr,pos+1,arr.length-1);

            }
        }
        int temp = arr[pos];
        arr[pos] = arr[p2];
        arr[p2] =temp;
        return arr;
    }
}
