package com.leetcode;

import java.util.*;

public class leetcode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
//        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i])){
//                ArrayList<Integer> list = map.get(nums[i]);
//                list.add(i);
//            }else{
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(nums[i],list);
//            }
//        }
        int curi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {
            if(nums[i]==curi){
                continue;
            }else{
                curi = nums[i];
            }
            int curj = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if(nums[j]==curj){
                    continue;
                }else{
                    curj = nums[j];
                }
                int p1 = j+1;
                int p2 = nums.length-1;
                while (p1<p2){
                    long curSum = (long)(nums[i])+nums[j]+nums[p1]+nums[p2];
                    if(curSum>target){
                        p2--;
                    } else if (curSum<target) {
                        p1++;
                    }else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[p1]);
                        temp.add(nums[p2]);
                        ans.add(temp);
                        int curP1 = nums[p1];
                        while (p1<p2&&nums[p1]==curP1){
                            p1++;
                        }
                        int curP2 = nums[p2];
                        while (p1<p2&&nums[p2-1]==curP2){
                            p2--;
                        }

                    }
                }

//                for (int k = j+1; k < nums.length-1 ; k++) {
//                    int curTarget = target- nums[i] - nums[j] - nums[k];
//                    if(curTarget<nums[k]){
//                        break;
//                    }
//                    if(map.containsKey(curTarget)){
//                        List<Integer> list= map.get(curTarget);
//                        for (Integer pos:
//                                list) {
//                            if(pos>k){
//                                List<Integer> temp = new ArrayList<>();
//                                temp.add(nums[i]);
//                                temp.add(nums[j]);
//                                temp.add(nums[k]);
//                                temp.add(nums[pos]);
//                                ans.add(temp);
//                            }
//                        }
//                    }
//
//                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_18 demo = new leetcode_18();
        demo.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296);
    }
}
