package com.leetcode;

import java.util.ArrayList;

public class leetcode_6 {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // 根据行数简历字符数组
        ArrayList<StringBuilder> strings = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            strings.add(new StringBuilder());
        }
        char[] chars = s.toCharArray();
        int n = numRows - 1;
        for (int i = 0; i < chars.length; i++) {
            int pos = Math.abs(i % (n * 2) - n);
            StringBuilder sb = strings.get(pos);
            sb.append(chars[i]);
        }

        String ans = "";
        for (int i = n; i >= 0; i--) {
            ans += strings.get(i).toString();
        }

        return ans;
    }

    public static void main(String[] args) {
        leetcode_6 demo = new leetcode_6();
        demo.convert("PAYPALISHIRING", 1);
    }
}
