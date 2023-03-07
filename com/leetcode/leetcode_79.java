package com.leetcode;

public class leetcode_79 {
    char [][]board;
    boolean [][]visited;

    boolean [][][]checked;


    public final static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };


    public boolean exist(char[][] board, String word) {
        int l = board.length;
        int w = board[0].length;
        this.board = board;
        this.visited = new boolean[l][w];
        this.checked = new boolean[l][w][word.length()];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if(go_dfs(i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean go_dfs(int curX,int curY,String word,int pos){
        if(pos+1 ==word.length()&&word.charAt(pos)==board[curX][curY]){
            return true;
        }
        if(word.charAt(pos)!=board[curX][curY]){
            return false;
        }else {
            visited[curX][curY] = true;
            //开始往四个方向拓展
            boolean Flag =false;
            for (int i = 0; i < 4; i++) {
                int nextX = curX+dirs[i][0];
                int nextY = curY+dirs[i][1];
                if(nextX>=board.length||nextX<0||nextY>=board[0].length||nextY<0||visited[nextX][nextY]){
                    continue;
                }

                if(go_dfs(nextX,nextY,word,pos+1)){
                    Flag = true;
                    break;
                }
            }
            //要是都不行
            if(!Flag){
                visited[curX][curY]=false;
            }
            return Flag;
        }
    }

    public static void main(String[] args) {
        leetcode_79 demo = new leetcode_79();
        demo.exist(new char[][]{{'a'}},"a");
    }
}
