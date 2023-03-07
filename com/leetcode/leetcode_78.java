package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78 {
    public List<List<Integer>> subsets(int[] nums) {
        int limit = (1<<nums.length)-1;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= limit; i++) {
            List<Integer> tempL = new ArrayList<>();
            int temp = i;
            int count = 0;
            while(temp>0){
                if((temp&1)==1){
                    tempL.add(nums[count]);
                }
                count++;
                temp = temp>>1;
            }
            ans.add(tempL);
        }
        return ans;
    }
}
