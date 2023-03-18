package com.interview.meituan20230318;

import java.util.Scanner;

public class t3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int p1 = 0;
        int p2 = s.length() - 1;
        int count = 2;
        char[] chars = s.toCharArray();
        int unmatch = 0;
        while (p1 < p2) {
            if (chars[p1] != chars[p2]) {
                unmatch++;
            }
            p1++;
            p2--;
        }
        //原来就是回文子串
        if (unmatch == 0) {
            //尽量修改前置位
            p1 = 0;
            p2 = chars.length - 1;
            while (p1 <= p2&count>0) {
                if (chars[p1] != 'a') {
                    chars[p1] = 'a';
                    chars[p2] = 'a';
                    count-=2;
                }
                p1++;
                p2--;
            }
        } else if (unmatch ==1) {
            p1 = 0;
            p2 = chars.length-1;
            while (p1 < p2) {
                if (chars[p1] != chars[p2]) {

                    if(chars[p1]=='a'){
                        chars[p2] ='a';
                        count--;
                        if(chars[chars.length>>1]!='a'&&count>0){
                            chars[chars.length>>1] = 'a';
                            count--;
                        }
                    }else{
                        chars[p1] = 'a';
                        count-- ;
                        if(chars[p2]!='a'){
                            count--;
                            chars[p2] ='a';
                        }
                        if(chars[chars.length>>1]!='a'&&count>0){
                            chars[chars.length>>1] = 'a';
                            count--;
                        }

                    }

                }
                p1++;
                p2--;
            }
        }else{
            p1 = 0;
            p2 = chars.length-1;
            while(p1<p2&&count>0){
                if(chars[p1]!=chars[p2]){
                    char turn = chars[p1]<chars[p2]?chars[p1]:chars[p2];
                    chars[p1] = turn;
                    chars[p2] = turn;
                    count--;
                }
                p1++;
                p2--;
            }
        }


//        while(p1<p2&&count>0){
//            if(chars[p1]!=chars[p2]){
//                char turn = chars[p1]<chars[p2]?chars[p1]:chars[p2];
//                chars[p1] = turn;
//                chars[p2] = turn;
//                count--;
//            }
//            p1++;
//            p2--;
//
//        }
//        if(count==2){
//            p1 = 0;
//            p2 = chars.length-1;
//            while(p1<p2&&count>0){
//                if(chars[p1]!='a'){
//                    chars[p1] = 'a';
//                    chars[p2] = 'a';
//                    count-=2;
//                }
//                p1++;
//                p2--;
//
//
//            }
//        }
//        if(count>=1&&chars.length%2==1&&chars[chars.length>>1]!='a'){
//            chars[chars.length>>1] = 'a';
//            count--;
//        }


        for (char c :
                chars) {
            System.out.print(c);
        }
    }
}
