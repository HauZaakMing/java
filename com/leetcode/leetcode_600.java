package com.leetcode;

public class leetcode_600 {
    public static int[][] dp;
    public int findIntegers(int n) {
        String number = Integer.toBinaryString(n);
        dp = new int[2][number.length()];
        return countDiscontinued1(0,false,false,true,false,number)+1;
    }

    public int countDiscontinued1(int pos,boolean hasOne,boolean lastOne,boolean isLimited,boolean isStart,String number){
        //给出退出条件
        if(pos==number.length()){
            if(isStart&&hasOne){
                return 1;
            }else{
                return 0;
            }
        }
        if(!isLimited&&isStart&&dp[lastOne?1:0][pos]!=0){
            return dp[lastOne?1:0][pos];
        }

        int cur = Integer.parseInt(number.substring(pos,pos+1));
        int upLimit = isLimited?cur:1;

        int lowLimit = isStart?0:1;

        //开始计数
        int count =0;
        for (int i = lowLimit; i <= upLimit; i++) {
            if(lastOne&&i==1){
                continue;
            }else{
                count+=countDiscontinued1(pos+1,hasOne|i==1,i==1,isLimited&&i==cur,true,number);
            }
        }
        if(!isStart){
            count+=countDiscontinued1(pos+1,false,false,false,false,number);
        }
        if(!isLimited&&isStart){
            dp[lastOne?1:0][pos] = count;
        }
        return count;
    }

    public static void main(String[] args) {
        leetcode_600 demo = new leetcode_600();
        demo.findIntegers(5);
    }


}
