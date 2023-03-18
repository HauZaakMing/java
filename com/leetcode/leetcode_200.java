package com.leetcode;

import java.util.HashMap;

public class leetcode_200 {
    public int numIslands(char[][] grid) {
        //自节点 岛的根节点
        HashMap<Node,Node> map = new HashMap<>();
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Node n = new Node(i,j);
                map.put(n,n);
            }
        }
        return 0;

    }

    class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


