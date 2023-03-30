package com.leetcode;

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

    }
}
