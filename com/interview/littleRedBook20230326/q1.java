package com.interview.littleRedBook20230326;

import java.util.Scanner;

public class q1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int t = (chars[i]-'a'-3+26)%26;
            chars[i] = (char)(t+'a');
        }
        for (int i = 0; i < n; i++) {
            System.out.print(chars[i]);
        }
    }
}
