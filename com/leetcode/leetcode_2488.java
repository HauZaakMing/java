package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode_2488 {
    HashSet<Long> set;
    public int countSubarrays(int[] nums, int k) {
        set = new HashSet<>();
        int l = 0;
        int g = 0;
        boolean flag = false;
        int ans = 1;
        set.add(0L);
        int distance = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<k){
                l++;
            } else if (nums[i]>k) {
                g++;
            }else{
                flag = true;
            }
            long key = keyGen(l,g);
            //k还没出现
            if(!flag){
                set.add(key);
            }else{

                ans += findMatch(l,g,distance);
                distance ++;
            }



        }

        return ans;
    }

    public long keyGen(int l,int g){
        long key = l*1000000+g;
        return key;
    }

    public int findMatch(int l,int g,int distance){
        //l==r  l+1==g
        int count = 0;

        for (int i = Math.max(distance/2,1); i<=l && i<=g; i++) {
            int l_diff = l-i;
            int g_diff = g-i;
            long key = keyGen(l_diff,g_diff);
            if(set.contains(key)){
                count++;
            }
        }
        for (int i = distance/2; i<=l && i+1<=g; i++) {
            int l_diff = l-i;
            int g_diff = g-(i+1);
            long key = keyGen(l_diff,g_diff);
            if(set.contains(key)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        leetcode_2488 demo = new leetcode_2488();
        demo.countSubarrays(new int[]{4,1,3,2},1);
    }
}
