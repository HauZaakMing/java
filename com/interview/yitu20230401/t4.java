package com.interview.yitu20230401;

import java.util.Scanner;


public class t4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int matrixA[][] = new int[n][m];
        int matrixB[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }

        //b bT a
        int matrixBT[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixBT[i][j] = matrixB[j][i];
            }
        }
        int matrixAns[][];
        matrixAns = matrixMul(matrixMul(matrixB,matrixBT),matrixA);
        System.out.println(matrixAns.length+" "+matrixAns[0].length);
        for (int i = 0; i < matrixAns.length; i++) {
            for (int j = 0; j < matrixAns[0].length; j++) {
                System.out.print(matrixAns[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static int[][] matrixMul(int [][]l,int [][]r){
        int l1 = l.length;
        int l2 = r[0].length;
        int ans[][] = new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                for (int k = 0; k < l[0].length; k++) {
                    ans[i][j] += l[0][k]*r[k][0];
                }

            }
        }
        return ans;
    }
}
