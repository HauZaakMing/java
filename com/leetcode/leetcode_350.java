package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(p1<nums1.length&&p2<nums2.length){
            if(nums1[p1]==nums2[p2]){
                list.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1]<nums2[p2]) {
                p1++;
            }else{
                p2++;
            }
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
