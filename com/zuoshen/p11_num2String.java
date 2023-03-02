package com.zuoshen;

public class p11_num2String {
    public static int n2s(String num, int pos, String s) {
        if (pos == num.length()) {
            System.out.println(s);
            return 1;
        }
        // 要一个数字
        char c = (char) (Integer.parseInt(num.substring(pos, pos + 1)) + 'A' - 1);
        s = s + c;
        int n1 = n2s(num, pos + 1, s);
        s = s.substring(0, s.length() - 1);
        int n2 = 0;
        if (pos + 1 < num.length() && Integer.parseInt(num.substring(pos, pos + 2)) <= 26) {
            c = (char) (Integer.parseInt(num.substring(pos, pos + 2)) + 'A' - 1);
            s = s + c;
            n2 = n2s(num, pos + 2, s);
            s = s.substring(0, s.length() - 1);
        }

        return n1 + n2;
    }

    public static void main(String[] args) {
        System.out.println(n2s("11111", 0, ""));
        ;
    }
}
