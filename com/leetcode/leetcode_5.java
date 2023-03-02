package com.leetcode;

import java.util.Arrays;

public class leetcode_5 {
    // 最长回文子串，maracher算法
    public String longestPalindrome(String s) {
        s = s.replace("", "*");
        int[] lp = new int[s.length()];
        int maxL = 0;
        String ans = "";
        Arrays.fill(lp, 1);
        char[] cl = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int p1 = i - lp[i] / 2;
            int p2 = i + lp[i] / 2;
            while (p1 - 1 >= 0 && p2 + 1 < s.length() && cl[p1 - 1] == cl[p2 + 1]) {
                p1--;
                p2++;
            }
            int length = p2 - p1 + 1;
            lp[i] = length;
            if (length > maxL) {
                maxL = length;
                ans = s.substring(p1, p2 + 1);
            }
            int p = p2;
            while (--p > i) {
                lp[p] = Math.min(lp[2 * i - p], (p2 - p) * 2 + 1);
            }

        }

        return ans.replace("*", "");
    }

    public static void main(String[] args) {
        leetcode_5 demo = new leetcode_5();
        demo.longestPalindrome("bab");
    }
}
