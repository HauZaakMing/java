package com.leetcode;

import java.util.HashMap;

public class leetcode_1590 {
    //看了题解才能解决
    public int minSubarray(int[] nums, int p) {
        //求得x为总余值
        int x = 0;
        for (int num :
                nums) {
            x =(x+num)%p;
        }
        if(x==0){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int curx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curx = curx%p;
            if(map.containsKey((curx+p-x)%p)){
                int dis = i - map.get((curx+p-x)%p);
                if(dis<min){
                    min = dis;
                }
            }
            map.put(curx,i);
            curx = curx+nums[i];
        }
        curx = curx %p;
        if(map.containsKey((curx+p-x)%p)){
            int dis = nums.length - map.get((curx+p-x)%p);
            if(dis<min){
                min = dis;
            }
        }
        if(min==Integer.MAX_VALUE||min ==nums.length){
            return -1;
        }else{
            return min;
        }

    }

    public static void main(String[] args) {
        leetcode_1590 demo = new leetcode_1590();
        demo.minSubarray(new int[]{6,3,5,2},9);
    }

}
