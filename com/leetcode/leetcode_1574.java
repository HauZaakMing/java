package com.leetcode;

import java.util.Arrays;

public class leetcode_1574 {
    boolean []rVaild;


    //1574. 删除最短的子数组使剩余数组有序
    public int findLengthOfShortestSubarray(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int []copy = arr.clone();
        Arrays.sort(copy);
        int compare = Arrays.compare(arr, copy);
        if(compare == 0){
            return 0;
        }

        //用一个boolean数组表示从R开始的arr是否有序
        rVaild = new boolean[arr.length];
        rVaild[arr.length-1] = true;
        for (int i = arr.length-2; i >=0 ; i--) {
            if(arr[i]<=arr[i+1]){
                rVaild[i] = true;
            }
        }

        //开始删除，LR为删除边缘
        for (int L = 0; L < arr.length; L++) {
            if(L-1>=0&&L-2>=0){
                if(arr[L-1]<arr[L-2]){
                    break;
                }
            }
            for (int R = L; R < arr.length ; R++) {
                if(R-L+1>ans){
                    break;
                }
                if(check(arr,L,R)){
                    ans = Math.min(ans,R-L+1);
                    break;
                }
            }

        }
        return ans;

    }


    public boolean check(int[] arr,int l,int r){
        //检查r的右侧
        if(r+1<arr.length){
            if(!rVaild[r+1]){
                return false;
            }
        }
        //检查L-1和R+1的关系
        if(l-1>=0&&r+1<arr.length){
            if(arr[l-1]>arr[r+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode_1574 demo = new leetcode_1574();
        demo.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5});

    }
}
