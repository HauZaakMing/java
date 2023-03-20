package com.sword2offer;

public class q_4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]<=target&&matrix[i][matrix[0].length-1]>=target){
                if(matrix[i][0]>target){
                    break;
                }
                if(BinaryFind(matrix,i,target)){
                    return true;
                }

            }
        }
        return false;
    }

    public boolean BinaryFind(int[][] matrix, int p, int target) {
        //先检查行
        int l = 0;
        int r = matrix[0].length;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (matrix[p][mid] < target) {
                l = mid + 1;
            } else if (matrix[p][mid] > target) {
                r = mid - 1;
            }else{
                return true;
            }
        }


        return false;
    }
}
