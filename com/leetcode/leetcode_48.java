package com.leetcode;

public class leetcode_48 {

    public void rotate(int[][] matrix) {

        int l = matrix.length;

        int pi = 0;
        int pj = 0;
        int ni = 0;
        int nj = 0;
        for (int i = 0; i < l/2; i++) {
            for (int j = 0; j < l+1/2; j++) {
                if(i==l-1&&j==l-1&&matrix.length%2==1){

                    return;
                }
                pi = i;
                pj = j;
                //开始翻转
                int fornext = matrix[i][j];
                for (int k = 0; k < 4; k++) {
                    //生成下一坐标
                    ni = pj;
                    nj = l-1-pi;
                    // 保留它的值
                    int temp = matrix[ni][nj];
                    // 给下一坐标赋值
                    matrix[ni][nj] = fornext;
                    fornext = temp;
                    pi = ni;
                    pj = nj;

                }
            }
        }
    }


}
