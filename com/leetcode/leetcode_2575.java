package com.leetcode;

public class leetcode_2575 {

    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        // 当前最后不能整除的位数
        long last = 0;
        for (int i = 0; i < ans.length; i++) {
            last = last * 10 + Integer.parseInt(word.substring(i, i + 1));
            last = last % m;
            ans[i] = last == 0 ? 1 : 0;

        }

        return ans;
    }

    public static void main(String[] args) {
        leetcode_2575 demo = new leetcode_2575();

        demo.divisibilityArray("1010", 10);
    }
}
