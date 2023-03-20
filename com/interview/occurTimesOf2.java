package com.interview;

public class occurTimesOf2 {
    public static int[][] dp;
    public int numberOf2sInRange(int n) {
        String number = Integer.toString(n);
        //dp[当前已有几个2][所处的位置]
        dp = new int[number.length()][number.length()];
        return count2(0,0,true,false,number);
    }


    public int count2(int pos,int cur2times,boolean isLimited,boolean isStart,String number){
        //先写返回条件
        if(pos == number.length()){

            return isStart?cur2times:0;
        }
        if(isStart&&!isLimited&&dp[cur2times][pos]!=0){
            return dp[cur2times][pos];
        }
        int cur = Integer.parseInt(number.substring(pos,pos+1));
        //给出上下界
        int upLimit = isLimited?cur:9;
        int lowLimit = isStart?0:1;

        //开始算数
        int count = 0;
        for (int i = lowLimit; i <= upLimit ; i++) {

            count+=count2(pos+1,i==2?cur2times+1:cur2times,isLimited&&i==cur,true,number);
        }

        if(!isStart){
            count+=count2(pos+1,cur2times,false,isStart,number);
        }
        if(isStart&&!isLimited){
            dp[cur2times][pos] = count;
        }
        return count;

    }
}
