package com.zuoshen;

public class p11_printS {

    public static void ps(String s, int l) {
        if (l == 0) {
            return;
        }
        for (int i = 0; (i + l) < s.length(); i++) {
            System.out.println(s.substring(i, i + l));
        }
        ps(s, l - 1);
    }

    public static void main(String[] args) {
        String s = "asdsdfasd";
        ps(s, s.length());
    }
}
