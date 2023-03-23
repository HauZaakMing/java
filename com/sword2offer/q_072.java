package com.sword2offer;

public class q_072 {
    //剑指 Offer II 072. 求平方根
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        long left = 1;
        long right = x;
        while(left<right){
            long mid = left+((right-left)>>1);
            if(mid*mid>x){
                right = mid-1;
            } else if (mid*mid<x) {
                left = mid+1;
            }else{
                return (int)mid;
            }
        }
        while (right*right>x){
            right--;
        }
        return (int)right;
    }

    public static void main(String[] args) {
        q_072 demo = new q_072();
        demo.mySqrt(2147395599);
    }
}
