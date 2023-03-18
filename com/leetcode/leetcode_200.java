package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_200 {
    public static boolean visited[][];
    public static final int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1} };
    public int numIslands(char[][] grid) {
        //自节点 岛的根节点
//        HashMap<Node,Node> map = new HashMap<>();
        //BFS
        int length1 = grid.length;
        int length2 = grid[0].length;
        visited = new boolean[length1][length2];
        int count = 0;
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if(!visited[i][j]&&grid[i][j]=='1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;

    }

    private void bfs(char[][] grid, int i, int j) {

        Node n = new Node(i,j);
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        visited[i][j] = true;
        while(!queue.isEmpty()){

            Node temp = queue.poll();
            int x = temp.x;
            int y = temp.y;

            for (int k = 0; k < 4; k++) {
                int nx = x+dirs[k][0];
                int ny = y+dirs[k][1];
                if(nx<0||ny<0||nx>=grid.length||ny>=grid[0].length){
                    continue;
                }
                if(!visited[nx][ny]&&grid[nx][ny]=='1'){
                    temp = new Node(nx,ny);
                    queue.add(temp);
                    visited[nx][ny] = true;
                }
            }
        }
    }

    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        leetcode_200 demo = new leetcode_200();
        demo.numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}});
    }

}


