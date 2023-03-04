package com.leetcode;

import java.util.ArrayList;

public class leetcode_2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int p1 = 0;
        int p2 = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1][0] == nums2[p2][0]) {
                ans.add(new int[] { nums1[p1][0], nums1[p1][1] + nums2[p2][1] });
                p1++;
                p2++;
            } else {
                if (nums1[p1][0] < nums2[p2][0]) {
                    ans.add(new int[] { nums1[p1][0], nums1[p1][1] });
                    p1++;
                } else {
                    ans.add(new int[] { nums2[p2][0], nums2[p2][1] });
                    p2++;
                }
            }
        }

        while (p1 < nums1.length) {
            ans.add(new int[] { nums1[p1][0], nums1[p1][1] });
            p1++;
        }

        while (p2 < nums2.length) {
            ans.add(new int[] { nums2[p2][0], nums2[p2][1] });
            p2++;
        }

        int l = ans.size();
        int[][] ans1 = new int[l][2];
        for (int i = 0; i < ans1.length; i++) {
            ans1[i] = ans.get(i);
        }
        return ans1;
    }

    public static void main(String[] args) {
        leetcode_2570 demo = new leetcode_2570();
        demo.mergeArrays(null, null);
    }

}
