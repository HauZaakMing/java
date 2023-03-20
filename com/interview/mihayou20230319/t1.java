package com.interview.mihayou20230319;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class t1 {
    public static int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
    public static HashMap<Character,Integer> map1 = new HashMap<>();
    public static HashMap<Character,Integer> map2 = new HashMap<>();

    public static boolean visited[][];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char colors[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                colors[i][j] = s.charAt(j);
            }
        }
        map1.put('R',1);
        map1.put('G',0);
        map1.put('B',0);
        int count1= 0;
        visited = new boolean[colors.length][colors[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]){
                    colorBlindBFS(colors,i,j);
                    count1++;
                }

            }
        }
        map2.put('R',2);
        map2.put('G',1);
        map2.put('B',0);
        int count2=0;
        visited = new boolean[colors.length][colors[0].length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]){
                    normalBFS(colors,i,j);
                    count2++;
                }

            }
        }
        System.out.println(count2-count1);

    }

    public static void colorBlindBFS(char colors[][],int x_s,int y_s) {
        Node n = new Node(x_s, y_s);
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        visited[x_s][y_s] =true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x+dirs[i][0];
                int ny = y+dirs[i][1];
                if(nx<0||ny<0||nx>=colors.length||ny>=colors[0].length){
                    continue;
                }
                if(map1.get(colors[x][y])==map1.get(colors[nx][ny])&&!visited[nx][ny]){
                    queue.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void normalBFS(char colors[][],int x_s,int y_s) {
        Node n = new Node(x_s, y_s);
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);
        visited[x_s][y_s] =true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x+dirs[i][0];
                int ny = y+dirs[i][1];
                if(nx<0||ny<0||nx>=colors.length||ny>=colors[0].length){
                    continue;
                }
                if(map2.get(colors[x][y])==map2.get(colors[nx][ny])&&!visited[nx][ny]){
                    queue.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }



}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
