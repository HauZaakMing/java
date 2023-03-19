package com.leetcode;

public class leetcode_6322 {

    public static int[][] dirs = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

    public boolean checkValidGrid(int[][] grid) {
        //用dfs求方案可行
        return dfs(grid,0,0,0);

    }

    public boolean dfs(int [][]grid,int x,int y,int times){
        if(times == grid.length*grid.length-1){
            return true;
        }
        int target = times+1;

        for (int i = 0; i < 8; i++) {
            int nx = x+dirs[i][0];
            int ny = y+dirs[i][1];
            if(nx<0||nx>=grid.length||ny<0||ny>=grid[0].length){
                continue;
            }
            if(grid[nx][ny]==times+1){
                return dfs(grid,nx,ny,times+1);
            }
        }
        return false;
    }
}
