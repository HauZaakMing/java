package com.interview.JD20230325;

import java.util.Scanner;

public class t2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            System.out.println(getMinFac(a));
        }
    }

    public static long getMinFac(long num){
        long l = 2;
        long r = num;
        while(l<r){
            long mid = (l+r)>>1;
            if(mid*mid<=num){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        for (int i = (int)l; i <= num ; i++) {
            if(num%i==0&&i*i>num){
                return i;
            }
        }
        return 0;
    }


}
