package com.sword2offer;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.util.Arrays;
import java.util.Collections;

public class q_088 {
    //剑指 Offer II 088. 爬楼梯的最少成本
    public int minCostClimbingStairs(int[] cost) {
        int c1 = 0;
        int c2 = 0;
        if(cost.length==1||cost.length==2){
            Arrays.sort(cost);
            return cost[0];
        }
        int min = 0;
        for (int i = 2; i <cost.length+1 ; i++) {
            min = Math.min(c1+cost[i-1],c2+cost[i-2]);
            c2 = c1;
            c1 = min;

        }


        return min;
    }

    public static void main(String[] args) {
        q_088 demo = new q_088();
        demo.minCostClimbingStairs(new int[]{1});
    }
}
