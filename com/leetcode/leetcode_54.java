package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class leetcode_54 {
    public static boolean visted[][];

    public final static int[][] dirs = { { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 0 } };


    public List<Integer> spiralOrder1(int[][] matrix) {
        visted = new boolean[matrix.length][matrix[0].length];
        int x = 0;
        int y = 0;
        visted[0][0] = true;
        List<Integer> ans = new LinkedList<>();
        ans.add(matrix[0][0]);

        while (true) {
            //右
            boolean flag = false;
            while (y + 1 < matrix[0].length && !visted[x][y + 1]) {
                ans.add(matrix[x][y + 1]);
                visted[x][y + 1] = true;
                y++;
                flag = true;
            }
            //下
            while (x + 1 < matrix.length && !visted[x + 1][y]) {
                ans.add(matrix[x + 1][y]);
                visted[x + 1][y] = true;
                x++;
                flag = true;
            }
            //左
            while (y - 1 >= 0 && !visted[x][y - 1]) {
                ans.add(matrix[x][y - 1]);
                visted[x][y - 1] = true;
                y--;
                flag = true;
            }
            //上
            while (x - 1 >= 0 && !visted[x - 1][y]) {
                ans.add(matrix[x - 1][y]);
                visted[x - 1][y] = true;
                x--;
                flag = true;
            }
            if(!flag){
                break;
            }
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        visted = new boolean[matrix.length][matrix[0].length];
        int x = 0;
        int y = 0;
        visted[0][0] = true;
        List<Integer> ans = new LinkedList<>();
        ans.add(matrix[0][0]);

        while (true){
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                while (0<=x+dirs[i][0]&&x+dirs[i][0]<matrix.length&&0<=y+dirs[i][1]&&y+dirs[i][1]<matrix[0].length&&!visted[x+dirs[i][0]][y+dirs[i][1]]){
                    x = x+dirs[i][0];
                    y = y+dirs[i][1];
                    flag=true;
                    ans.add(matrix[x][y]);
                }
            }
            if(!flag){
                break;
            }
        }
        return ans;
    }
}
