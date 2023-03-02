package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.PriorityQueue;

public class leetcode_2577 {

    public final static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    // 利用BFS
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        // HashSet<Node> set = new HashSet<>();
        int[][] visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }

        visit[0][0] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>((Node a, Node b) -> a.curT - b.curT);

        Node start = new Node(0, 0, 1);
        q.add(start);
        // set.add(start);

        while (!q.isEmpty()) {
            Node n1 = q.poll();
            ArrayList<Node> nestP = getNext(n1, grid, visit);
            for (Node node : nestP) {
                if (node.x == grid.length - 1 && node.y == grid[0].length - 1) {
                    return node.curT - 1;
                } else {
                    q.add(node);

                }

            }
        }

        return -1;
    }

    class Node {
        int x;
        int y;
        int curT;

        public Node(int x, int y, int curT) {
            this.x = x;
            this.y = y;
            this.curT = curT;
        }
    }

    public ArrayList<Node> getNext(Node n, int[][] grid, int[][] visit) {
        ArrayList<Node> nodeList = new ArrayList<>();
        // 获取位置
        int x = n.x;
        int y = n.y;
        int curT = n.curT;

        // 上
        // if (x > 0 && grid[x - 1][y] <= curT) {
        // Node n1 = new Node(x - 1, y, curT + 1);
        // if (!selected.contains(n1)) {
        // nodeList.add(n1);
        // }
        // }
        // // 下
        // if (x < grid.length - 1 && grid[x + 1][y] <= curT) {
        // Node n1 = new Node(x + 1, y, curT + 1);
        // if (!selected.contains(n1)) {
        // nodeList.add(n1);
        // }
        // }
        // // 左
        // if (y > 0 && grid[x][y - 1] <= curT) {
        // Node n1 = new Node(x, y - 1, curT + 1);
        // if (!selected.contains(n1)) {
        // nodeList.add(n1);
        // }
        // }
        // // 右
        // if (y < grid[0].length - 1 && grid[x][y + 1] <= curT) {
        // Node n1 = new Node(x, y + 1, curT + 1);
        // if (!selected.contains(n1)) {
        // nodeList.add(n1);
        // }
        // }
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                // 当前可以进去
                if (curT >= grid[nx][ny]) {
                    // 且是新发现的快路子，进去
                    if (curT + 1 < visit[nx][ny]) {
                        nodeList.add(new Node(nx, ny, curT + 1));
                        visit[nx][ny] = curT + 1;
                    }

                    // 当前不能，那就左右横条等待
                } else {

                    // 要是奇偶性相同
                    if ((curT & 1) == (grid[nx][ny] & 1)) {
                        int nt = grid[nx][ny] + 1;
                        if (nt < visit[nx][ny]) {
                            nodeList.add(new Node(nx, ny, nt));
                            visit[nx][ny] = curT + 1;
                        }
                    } else {
                        int nt = grid[nx][ny] + 2;
                        if (nt < visit[nx][ny]) {
                            nodeList.add(new Node(nx, ny, nt));
                            visit[nx][ny] = curT + 1;
                        }
                    }

                }
            }

        }
        return nodeList;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 3, 2 }, { 5, 1, 2, 5 }, { 4, 3, 8, 6 } };
        leetcode_2577 demo = new leetcode_2577();
        demo.minimumTime(grid);
    }
}
