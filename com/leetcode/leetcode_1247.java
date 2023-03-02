package com.leetcode;

public class leetcode_1247 {

    public int minimumSwap(String s1, String s2) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else {
                // a 上0下1
                // b 上1下0
                if (s1.charAt(i) == 'x') {
                    a++;
                } else {
                    b++;
                }
            }
        }
        if ((a + b) % 2 == 1) {
            return -1;
        } else {
            return a / 2 + b / 2 + (a % 2) * 2;
        }

    }

    public static void main(String[] args) {
        leetcode_1247 demo = new leetcode_1247();
        demo.minimumSwap("xy", "yx");
    }
}
