package com.zuoshen;

public class p11_hannoi {

    // 递归分割
    public static void hannoi(int i, int start, int end, int other) {
        if (i == 1) {
            System.out.println(start + "->" + end + ": 1");
        } else {
            hannoi(i - 1, start, other, end);
            System.out.println(start + "->" + end + ": " + i);
            hannoi(i - 1, other, end, start);
        }
    }

    public static void main(String[] args) {
        hannoi(5, 0, 2, 1);
    }
}
