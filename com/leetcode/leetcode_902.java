package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class leetcode_902 {
    int []dp;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String number = Integer.toString(n);
        HashSet<Integer> digs = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            digs.add(Integer.parseInt(digits[i]));
        }
        dp = new int[number.length()];
        return findNoBigger(0,0,true,false,number,digs);
    }

    public int findNoBigger(int pos,int curNum,boolean isLimited,boolean isStart,String number,HashSet<Integer> digs){
        //给定推出条件
        if(pos==number.length()){
            return isStart?1:0;
        }

        if(!isLimited&&isStart&&dp[pos]!=0){
            return dp[pos];
        }

        //给出上下界
        int cur = Integer.parseInt(number.substring(pos,pos+1));
        int upLimit = isLimited?cur:9;
        int lowLimit = isStart?0:1;

        //开始计数
        int count = 0;
        for (int i = lowLimit; i <= upLimit ; i++) {
            int tempNum = curNum+(int)(i*Math.pow(10,number.length()-pos-1));
            if(tempNum>Integer.parseInt(number)){
                break;
            }else{
                if(digs.contains(i)){
                    count+=findNoBigger(pos+1,tempNum,isLimited&&i==cur,true,number,digs);
                }else{
                    continue;
                }

            }
        }

        if(!isStart){
            count+=findNoBigger(pos+1,0,false,false,number,digs);
        }

        if(!isLimited&&isStart){
            dp[pos] = count;
        }
        return count;
    }
}
