package com.leetcode;

public class leetcode_2571 {
    public int minOperations(int n) {
        if (n == 0) {
            return 0;
        }

        int p = 0;
        int temp = n;
        while (temp > 0) {
            temp = temp >> 1;
            p++;
        }
        int left = 1 << (p - 1);
        int right = 1 << (p);

        int min = Math.min(Math.abs(left - n), Math.abs(right - n));
        int ans = 1 + minOperations(min);
        return ans;

    }

    public static void main(String[] args) {

    }
}
