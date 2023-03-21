package com.leetcode;

public class leetcode_2469 {

    public double[] convertTemperature(double celsius) {
        double ans[] = new double[2];
        ans[0] = celsius+243.15;
        ans[1] = celsius*1.8+32.0;
        return ans;
    }
}
