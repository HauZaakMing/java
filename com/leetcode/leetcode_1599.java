package com.leetcode;

public class leetcode_1599 {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        if(boardingCost*4<runningCost){
            return -1;
        }
        int wait = 0;
        int curT = 0;
        int max = 0;
        int curP = 0;
        int maxR = 0;
        while (wait!= 0||curT<customers.length){
            if(curT<customers.length){
                wait += customers[curT];
            }
            int board = Math.min(4,wait);
            curP += boardingCost*(board)-runningCost;
            if(curP>max){
                max = curP;
                maxR = curT+1;
            }
            wait -= board;
            curT ++;
        }
        if(max<=0){
            return -1;
        }else{
            return maxR;
        }

    }

    public static void main(String[] args) {
        leetcode_1599 demo = new leetcode_1599();
        System.out.println(demo.minOperationsMaxProfit(new int[]{8,3},5,6));
    }
}
