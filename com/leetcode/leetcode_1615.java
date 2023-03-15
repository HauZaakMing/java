package com.leetcode;

import java.util.*;

public class leetcode_1615 {

    public int maximalNetworkRank(int n, int[][] roads) {
        HashSet<Integer> []sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        int[] root = new int[n];
//        Arrays.setAll(list,e->new ArrayList<>());
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < roads.length; i++) {
            int s = roads[i][0];
            int e = roads[i][1];
            sets[s].add(e);
            sets[e].add(s);


        }
        int ans = 0;
//        for (int i = 0; i < roads.length; i++) {
//
//            int s = roads[i][0];
//            int e = roads[i][1];
//            int temp = list[s] + list[e] - 1;
//            ans = Math.max(ans, temp);
//        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                if(sets[i].contains(j)){
                    ans = Math.max(ans,sets[i].size()+sets[j].size()-1);
                }else{
                    ans = Math.max(ans,sets[i].size()+sets[j].size());
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        leetcode_1615 demo = new leetcode_1615();
        demo.maximalNetworkRank(5, new int[][]{{2,3},{0,3},{0,4},{4,1}});
    }
}
