package com.interview;

import java.util.Scanner;

public class m1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length()==1){
            System.out.println(0);
        }
        int p1 = 1;
        int ans = 0;
        while(p1!=s.length()){
            if(s.charAt(p1-1)==s.charAt((p1))){
                ans++;
                p1 = p1+2;
            }else{
                p1 = p1+1;
            }

        }
        System.out.println(ans);
    }
}
