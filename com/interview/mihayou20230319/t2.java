package com.interview.mihayou20230319;

import java.util.Scanner;

public class t2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            if(f1(s1,s2)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }

    public static boolean f1(String s1,String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int len_diff = Math.abs(len1-len2);
        //如果差距不是3的倍数，返回假
        if(len_diff%3!=0){
            return false;
        }
        
        if(len1 == len2){
            if(s1.equals(s2)){
                return true;
            }
            //其他情况下要求是米哈游序列夹杂其他序列
        }
        if(len1>len2){
            return true;
        }
        if(len2>len1){
            return false;
        }
        return false;
    }

//    public static int isMHY(String s){
//
//        int countM = 0;
//        int countH = 0;
//        int countY = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i)=='m'){
//                countM++;
//            } else if (s.charAt(i)=='h'&&countH<countM) {
//                countH++;
//            } else if (s.charAt(i) =='y'&&countY<countH) {
//                countY++;
//            }
//        }
//    }
}
