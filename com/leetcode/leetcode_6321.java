package com.leetcode;

import java.util.HashMap;

public class leetcode_6321 {

    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            if(nums[i]>=0){
                temp = nums[i]%value;
            }else{
                temp = ((Math.abs(nums[i]/value)+1)*value+nums[i])%value;
            }

            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(i%value)||map.get(i%value)==0){
                return i;
            }else{
                map.put(i%value,map.get(i%value)-1);
            }
        }
        return nums.length;

    }

    public static void main(String[] args) {
        leetcode_6321 demo = new leetcode_6321();
        demo.findSmallestInteger(new int[]{1,-10,7,13,6,8},5);
    }
}
