package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class leetcode_1637 {

    public int maxWidthOfVerticalArea1(int[][] points) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < points.length; i++) {
            set.add(points[i][0]);
        }


        int ans = 0;
        int pre = -1;
        for (Integer integer : set) {
            if (pre != -1) {
                ans = Math.max(integer - pre, ans);
            }
            pre = integer;

        }
        return ans;
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points,(Comparator.comparingInt(o -> o[0])));
        int pre = points[0][0];
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]-pre>ans){
                ans = points[i][0]-pre;
            }
            pre = points[i][0];
        }
        return ans;
    }
}
