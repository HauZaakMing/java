package com.leetcode;

public class leetcode_1012 {
    public static int dp[][];

    public int numDupDigitsAtMostN(int n) {

        String number = Integer.toString(n);
        dp = new int[1<<10][number.length()];
        int diff = f(0,0,true,false,number);
        return n-diff;
    }


    //pos       当前需要选择数字的位置
    //mask      当前已经被选择了的数组集合
    //isLimited 当前是否会受到数字的约束，受到约束的话最多只能选择当前为的最高值
    //isStart   数字是否已经开始了，开始了才可以选择0
    public int f(int pos, int mask, boolean isLimited, boolean isStart,String number) {
        //第一步，先写推出条件
        if(pos == number.length()){
            return isStart?1:0;
        }
        if(!isLimited&&isStart&&dp[mask][pos]!=0){
            return dp[mask][pos];
        }
        //开始分开讨论
        //先根据isLimited,isStart定下能选的上限下限
        int cur = Integer.parseInt(number.substring(pos,pos+1));
        int upLimit = isLimited?cur:9;
        int lowLimit = isStart?0:1;
        int count = 0;
        //然后选择数字
        for (int i = lowLimit; i <= upLimit ; i++) {
            if (((mask>>i)&1)==1){
//                System.out.println(Integer.toBinaryString(mask));
                continue;
            }else {

                count += f(pos + 1, mask | 1 << i, isLimited && (i == cur), true, number);
            }




        }
        //要是之前一直还没开始放数字，可继续不放
        if(!isStart){
            count += f(pos+1,mask,false,isStart,number);
        }
        if(!isLimited&&isStart){
            dp[mask][pos] = count;
        }


        return count;
    }


    public static void main(String[] args) {
        leetcode_1012 demo = new leetcode_1012();
        System.out.println(demo.numDupDigitsAtMostN(1000));
    }
}
