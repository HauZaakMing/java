package com.leetcode;

public class leetcode_75 {

    public void sortColors(int[] nums) {
        int p1 = -1;
        int p2 = nums.length;
        int curp = 0;
        while (curp!=p2){
            if(nums[curp]==0){
                p1 = p1+1;
                swap(nums,p1,curp);
                curp++;
            } else if (nums[curp]==1) {
                curp++;
            }else{
                p2 = p2-1;
                swap(nums,p2,curp);

            }
        }
    }


    public static void swap(int []num,int p1,int p2){
        int temp = num[p2];
        num[p2] = num[p1];
        num[p1] = temp;

    }
}
