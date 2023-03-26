package com.leetcode;

import java.util.*;

public class leetcode_6357 {

    public List<Long> minOperations(int[] nums, int[] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Long> ans = new ArrayList<>();
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

        //获得minQ和maxQ
        long minQ = 0;
        long maxQ = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            minQ += value * Math.abs(min - key);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            maxQ += value * Math.abs(max - key);
        }

        //设置一个查询集
        HashMap<Integer,Long> check = new HashMap<>();
        if(min==max){
            for (int i = 0; i < queries.length; i++) {
                int q = queries[i];
                if(check.containsKey(q)){
                    ans.add(check.get(q));
                }else{
                    long op = 0;
                    for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                        Integer key = integerIntegerEntry.getKey();
                        Integer value = integerIntegerEntry.getValue();
                        op += value * Math.abs(q - key);
                    }
                    ans.add(op);
                    check.put(q,op);
                }


            }
        }else{
            for (int i = 0; i < queries.length; i++) {
                int q = queries[i];
                if(check.containsKey(q)){
                    ans.add(check.get(q));
                }
                else if(q>=max){
                    long temp = maxQ+(q-max)*nums.length;
                    ans.add(temp);
                } else if (q<=min) {
                    long temp = minQ+(min-q)*nums.length;
                    ans.add(temp);
                }else{
                    long op = 0;
                    for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                        Integer key = integerIntegerEntry.getKey();
                        Integer value = integerIntegerEntry.getValue();
                        op += value * Math.abs(q - key);
                    }
                    ans.add(op);
                    check.put(q,op);
                }


            }
        }


        return ans;
    }

    public static void main(String[] args) {
        leetcode_6357 demo = new leetcode_6357();
        demo.minOperations(new int[]{3,1,6,8},new int[]{1,5});
    }
}
