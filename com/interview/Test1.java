package com.interview;

import java.util.Scanner;

public class Test1 {
    static int v;
    static int x;
    static int y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        //求加油时长，二分查找

        double Tleft = 1e-10;
        double Tright = 1000000;
        double Tmid = 0;
        while(Math.abs(Tleft-Tright)>1e-9){
            Tmid = (Tleft+Tright)/2;

            if(getD(Tleft)*getD(Tmid)<0){
                Tright = Tmid-1e-12;
                continue;
            }
            if(getD(Tright)*getD(Tmid)<0){
                Tleft = Tmid+1e-12;
                continue;
            }
        }

        System.out.println(Tmid);
    }

    public static double getD(double t){
        return (-y*x)/Math.pow((v+x*t),2)+1;
    }
}
