package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class interview_1705 {

    public String[] findLongestSubarray(String[] array) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
//        int dp[] = new int[array.length+1];
        map.put(0,0);
        int ans_l = 0;
        int ans_r = 0;
        int max_length = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].charAt(0)-'A'>=0){
                count++;
            }else{
                count--;
            }
            if(map.containsKey(count)){
                int temp = map.get(count);
                if(i-temp+1>max_length){
                    max_length=i-temp+1;
                    ans_l = temp;
                    ans_r = i+1;
                }
            }else{
                map.put(count,i+1);
            }
        }
        if(max_length==0){
            return new String[]{};
        }
        String ans[] = new String[ans_r-ans_l];
        count = 0;

        for (int i = ans_l; i < ans_r ; i++) {
            ans[count++] = array[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        interview_1705 demo = new interview_1705();
        demo.findLongestSubarray(new String[]{"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"});
    }
}
