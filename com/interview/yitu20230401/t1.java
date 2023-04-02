package com.interview.yitu20230401;

import java.util.Scanner;

public class t1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<3){
            System.out.println("No Solution!");
            return;
        }
        for (int i = 1; i < n; i++) {
            if(!check7(i)){
                continue;
            }
            for (int j = i; j < n ; j++) {
                if(!check7(j)){
                    continue;
                }
                int target = n-i-j;
                if(target<1){
                    break;
                }
                if(check7(target)){
                    System.out.println(i+" "+j+" "+target);
                    return;
                }
            }
        }
    }

    static boolean check7(int num){
        if(num%7==0){
            return false;
        }
        while (num>0){
            if(num%10==7){
                return false;
            }
            num = num/10;
        }
        return true;
    }
}

