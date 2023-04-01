package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class leetcode_528 {


}

class Solution {
    double p[];
    public Solution(int[] w) {
        double sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum+=w[i];
        }
        p = new double[w.length];
        double pre = 0;
        for (int i = 0; i < w.length; i++) {
            p[i] = pre+w[i]/sum;
            pre = p[i];
        }
    }

    public int pickIndex() {
        Random random = new Random();
        double v = random.nextDouble();
        //二分查找其位置
        return bs(p,v);

    }

    public int bs(double p[],double v){
        int l = 0;
        int r = p.length-1;
        while (l<r){
            int mid = (l+r)>>1;
            if(p[mid]<v){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        for (int i = Math.max(0,l-2); i < p.length ; i++) {
            if(p[i]>v){
                return i;
            }
        }
        return 0;
    }
}