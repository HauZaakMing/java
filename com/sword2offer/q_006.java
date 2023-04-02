package com.sword2offer;

public class q_006 {
    //剑指 Offer II 006. 排序数组中两个数字之和
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length-1;
        while (p1<p2){
            if(numbers[p1]+numbers[p2]<target){
                p1++;
            } else if (numbers[p1]+numbers[p2]>target) {
                p2--;
            }else{
                return new int[]{p1,p2};
            }
        }
        return null;
    }
}
