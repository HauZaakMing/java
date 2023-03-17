package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_15_1 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        if(map.containsKey(0)&&map.get(0)>=3){
            List<Integer> temp = new ArrayList<>();
                        temp.add(0);
                        temp.add(0);
                        temp.add(0);
                        ans.add(temp);
        }

        int curp1 = Integer.MIN_VALUE;
        for (int p1 = 0; p1 < nums.length; p1++) {
            if(nums[p1]==curp1){
                continue;
            }
            curp1 = nums[p1];
            if(nums[p1]>=0){
                break;
            }
            int curp2 = Integer.MIN_VALUE;
            for (int p2 = p1+1; p2 < nums.length; p2++) {
                if(nums[p2]==curp2){
                    continue;
                }
                curp2 = nums[p2];
                if(nums[p1]+nums[p2]>0){
                    break;
                }

                int target = 0 - nums[p1] - nums[p2];
                if(target < nums[p2]){
                    break;
                }else if (target == nums[p2]&&target!=0){
                    if(map.get(nums[p2])>1){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[p1]);
                        temp.add(nums[p2]);
                        temp.add(target);
                        ans.add(temp);
                    }
                }else{
                    if(map.containsKey(target)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[p1]);
                        temp.add(nums[p2]);
                        temp.add(target);
                        ans.add(temp);
                    }
                }
                //纯粹用三指针会超时
                //那我可以用hashmap，也可以用二分，hashmap会快一些

                
//                int curp3 = Integer.MIN_VALUE;
//                for (int p3 = p2+1; p3 < nums.length; p3++) {
//                    if(nums[p3]==curp3){
//                        continue;
//                    }
//
//                    curp3= nums[p3];
//                    if(nums[p1]+nums[p2]+nums[p3]==0){
//                        List<Integer> temp = new ArrayList<>();
//                        temp.add(nums[p1]);
//                        temp.add(nums[p2]);
//                        temp.add(nums[p3]);
//                        ans.add(temp);
//                    }else if (nums[p1]+nums[p2]+nums[p3]>0){
//                        break;
//                    }
//
//
//                }
            }
        }
        return ans;
    }

}
