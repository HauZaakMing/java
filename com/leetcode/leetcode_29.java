package com.leetcode;

public class leetcode_29 {

//    public int divide(int dividend, int divisor) {
//
//        //排除溢出
//        if (dividend == Integer.MIN_VALUE && divisor == -1) {
//            return Integer.MAX_VALUE;
//        }
//
//
//
//        if(divisor == 1 ){
//            return  dividend;
//        }
//
//        //计算符号位 0 positive
//        int sign = 0;
//        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
//            sign = 1;
//        }
//        //转绝对值
//        dividend = Math.abs(dividend);
//        divisor = Math.abs(divisor);
//
//
//        int ans = 0;
//        while (dividend>=divisor){
//            for (int i = 0; i < 32; i++) {
//                if(dividend>divisor*(1<<i)){
//                    if(divisor*(1<<(i+1))<divisor){
//                        ans+=1<<i;
//                        dividend -= divisor*(1<<i);
//                        break;
//                    }
//
//                    continue;
//                }else if (dividend==divisor*(1<<i)){
//                    ans+=1<<i;
//                    dividend -= divisor*(1<<i);
//                    break;
//                }else{
//                    ans+=1<<(i-1);
//                    dividend -= divisor*(1<<(i-1));
//                    break;
//                }
//            }
//        }
//        return sign==0?ans:-ans;
//    }

    public static void main(String[] args) {
        leetcode_29 demo = new leetcode_29();
//        demo.divide(-2147483648,2);
    }
}
