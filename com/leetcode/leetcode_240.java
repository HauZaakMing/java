package com.leetcode;

public class leetcode_240 {
    public static final int [][]dirs = new int[][]{{0,1},{1,0}};
    public static int[][] matrix;
    public static boolean[][] check ;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        check = new boolean[matrix.length][matrix[0].length];
        return dfs_search(target,0,0);
    }

    public static boolean dfs_search(int target,int x,int y){
        if(check[x][y]){
            return false;
        }else{
            check[x][y] = true;
        }
        if(matrix[x][y]==target){
            return true;
        }else{
            boolean flag = false;
            for (int i = 0; i < 2; i++) {
                int nx = x +dirs[i][0];
                int ny = y +dirs[i][1];
                if(nx>matrix.length-1||ny>matrix[0].length-1){
                    continue;
                } else if (matrix[nx][ny]>target) {
                    continue;
                }else{

                    flag = dfs_search(target,nx,ny);
                    if(flag){
                        break;
                    }
                }


            }



            return flag;
        }
    }

}
