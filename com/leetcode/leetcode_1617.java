package com.leetcode;

import java.util.HashSet;

public class leetcode_1617 {
    //未完成
    HashSet<Integer> adjacent = new HashSet<>();
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int e = edges[i][1];
            int temp = (1<<s)|(1<<e);
            adjacent.add(temp);
        }

        for (int i = 3; i < (1<<n) ; i++) {

        }
        return null;
    }
}
