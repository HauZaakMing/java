package com.interview.littleRedBook20230326;

import java.util.Scanner;

public class q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数组长度
        int N = scanner.nextInt();
        //注入数组元素
        int nums[] = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        //操作次数
        int M = scanner.nextInt();
        int L[] = new int[M];
        int R[] = new int[M];
        int X[] = new int[M];
        //操作区间
        for (int i = 0; i < M; i++) {
            L[i] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            R[i] = scanner.nextInt();
        }
        //操作
        char ops[] = scanner.next().toCharArray();
        //
        for (int i = 0; i < M; i++) {
            X[i] = scanner.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int l = L[i]-1;
            int r = R[i]-1;
            switch (ops[i]){
                case '=':
                    for (int j = l; j <= r ; j++) {
                        nums[j] = X[i];
                    }
                    break;
                case '|':
                    for (int j = l; j <= r ; j++) {
                        nums[j] = nums[j] | X[i];
                    }
                    break;
                case '&':
                    for (int j = l; j <= r ; j++) {
                        nums[j] = nums[j] & X[i];
                    }
                    break;
            }

        }

        for (int i = 0; i < N; i++) {
            System.out.println(nums[i]);
        }
    }
}



