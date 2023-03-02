package com.leetcode;

public class leetcode_11 {

    public int maxArea(int[] height) {
        int max = 0;
        int p1 = 0;
        int p2 = height.length - 1;

        while (p1 != p2) {
            int area = (p2 - p1) * Math.min(height[p1], height[p2]);
            if (area > max) {
                max = area;
            }
            if (height[p1] > height[p2]) {
                p2--;
            } else if (height[p1] < height[p2]) {
                p1++;
            } else {
                // 要是都一样高，挑更高的那个去
                if (height[p1 + 1] > height[p2 - 1]) {
                    p1++;
                } else {
                    p2--;
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
