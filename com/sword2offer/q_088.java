package com.sword2offer;

public class q_088 {
    //剑指 Offer II 088. 爬楼梯的最少成本
    public int minCostClimbingStairs(int[] cost) {
        int c1= 0;
        int c2 = 0;
        if(cost.length==1||cost.length==2){
            return 0;
        }
        for (int i = 2; i <cost.length+1 ; i++) {
            int min = Math.min(c1,c2);

        }

        return 0;
    }
}
