package com.interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class m2 {
    public final static int[][] dirs = { { 0, 1 }, { 1, 0 } };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
//        int n = 1;
//        int m = 7;
//        int k = 2;
        int [][]matrix = new int[n][m];
        int [][]coins = new int[n][m];

        int [][]dp = new int[n][m];

        for (int i = 0; i <n; i++) {
            String s = sc.next();
            char []chars = s.toCharArray();
            for (int j = 0; j <m ; j++) {
                matrix[i][j] = chars[j]=='R'?0:1;
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
                coins[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = coins[0][0];
        //先处理边缘部分
        for (int i = 1; i < n ; i++) {
            if(matrix[i][0]==matrix[i-1][0]){
                dp[i][0] = dp[i-1][0]+coins[i][0];
            }else if(k>dp[i-1][0]){
                dp[i][0] = Integer.MIN_VALUE;
            }else{
                dp[i][0] = dp[i-1][0]+coins[i][0]-k;
            }

        }
        for (int i = 1; i < m; i++) {


            if(matrix[0][i]==matrix[0][i-1]){
                dp[0][i] = dp[0][i-1]+coins[0][i];
            }else if(k>dp[0][i-1]){
                dp[0][i] = Integer.MIN_VALUE;
            }else{
                dp[0][i] = dp[0][i-1]+coins[0][i]-k;
            }

        }
        //处理中间部分
        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                //从上面下来
                int temp1 = 0;
                int temp2 = 0;
                if(dp[i-1][j]<0){dp[i][j]=Integer.MIN_VALUE;}
                else if(matrix[i-1][j]==matrix[i][j]){
                    temp1 = dp[i-1][j]+coins[i][j];
                }else{
                    if(dp[i-1][j]<k){
                        temp1 = Integer.MIN_VALUE;
                    }else{
                        temp1 = dp[i-1][j]+coins[i][j]-k;
                    }
                }
                if(dp[i][j-1]<0){dp[i][j]=Integer.MIN_VALUE;}
                else if(matrix[i][j-1]==matrix[i][j]){
                    temp2 = dp[i][j-1]+coins[i][j];
                }else{
                    if(dp[i][j-1]<k){
                        temp2 = Integer.MIN_VALUE;
                    }else{
                        temp2 = dp[i][j-1]+coins[i][j]-k;
                    }
                }


                dp[i][j] = Math.max(temp1,temp2);
            }
        }

        int maxP = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxP = Math.max(maxP,dp[i][j]);
            }
        }
        System.out.println(maxP);






    }


}
