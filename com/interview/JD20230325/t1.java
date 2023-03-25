package com.interview.JD20230325;

import java.util.Scanner;

public class t1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        if(b==0&&a!=0){
            System.out.println(-1);
            return ;
        }
        if(a>b+1){
            System.out.println(-1);
            return ;
        }
        else{
            while (b>0&&a>0){
                b--;
                a--;
                System.out.print(1+" ");
                System.out.print(2+" ");
            }
            while (a>0){
                System.out.print(1+" ");
                a--;
            }
            while (b>0){
                System.out.print(2+" ");
                b--;
            }
        }

    }
}


class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}