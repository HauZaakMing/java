package com.leetcode;

public class bingary2String {

    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        int count = 1;
        while (num > 0 && count <= 30) {
            double temp = Math.pow(0.5, count);
            if (num >= temp) {
                sb.append("1");
                num = num - temp;
            } else {
                sb.append("0");
            }
            count++;
        }
        if (num != 0) {
            return "ERROR";
        } else {
            return sb.toString();
        }

    }

    public static void main(String[] args) {

    }
}
