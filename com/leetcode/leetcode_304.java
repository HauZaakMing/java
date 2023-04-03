package com.leetcode;

public class leetcode_304 {



}


class NumMatrix {
    int [][]matrix;
    int [][]preSum;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        preSum = new int[matrix.length][matrix[0].length];
        preSum[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            preSum[i][0] = preSum[i-1][0]+matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            preSum[0][i] = preSum[0][i-1]+matrix[0][i];
        }
        for (int i = 1; i < matrix.length ; i++) {
            for (int j = 1; j < matrix[0].length ; j++) {
                preSum[i][j] = preSum[i-1][j]+preSum[i][j-1]-preSum[i-1][j-1]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = preSum[row2][col2];
        if(col1-1>=0){
            res -= preSum[row2][col1-1];
        }
        if(row1-1>=0){
            res -= preSum[row1-1][col2];
        }
        if(col1-1>=0&&row1-1>=0){
            res += preSum[row1-1][col1-1];
        }
        return res;
    }
}