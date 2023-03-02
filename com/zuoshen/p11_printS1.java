package com.zuoshen;

public class p11_printS1 {

    public static void printS1(String s) {
        // 通过二进制状态位标记是否打印

        int l = s.length();
        int limit = (1 << l) - 1;
        for (int i = 0; i <= limit; i++) {
            int temp = i;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                if (temp % 2 == 1) {
                    sb.append(s.charAt(j));
                }
                temp = temp >> 1;
            }

            System.out.println(sb);
        }
    }

    public static void printS2(String s, int cur, String ps) {
        // 通过递归来实现字符串的选择打印
        if (cur == s.length()) {
            System.out.println(ps);
            return;
        }
        // 加入当前字符
        ps = ps + s.charAt(cur);
        printS2(s, cur + 1, ps);
        ps = ps.substring(0, ps.length() - 1);
        printS2(s, cur + 1, ps);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        printS2("asdfdwertyuiopd", 0, "");
        long end = System.currentTimeMillis();
        long t1 = end - start;

        start = System.currentTimeMillis();
        printS2("asdfdwertyuiopd", 0, "");
        end = System.currentTimeMillis();
        long t2 = end - start;
        System.out.println("t1: " + t1 + "ms  " + "t2: " + t2 + "ms  ");

    }
}
