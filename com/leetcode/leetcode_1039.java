package com.leetcode;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_1039 {
    //多边形切三角形，贪心策略不可行

    //状态储存
    HashMap<Long, Integer> map = new HashMap<>();

    int dp[][];

    public int minScoreTriangulation(int[] values) {
        dp = new int[values.length][values.length];
        int ans = dfs(0,values.length-1,values);
        return ans;
    }

    public int dfs(int i, int j, int []values) {
        if ((i + 1)%values.length == j) {
            return 0;
        }
        if ((i + 2)%values.length == j){
            if(dp[i][j]!=0){
                return dp[i][j];
            }
            int p = values[i]*values[i+1]*values[i+2];
            dp[i][j] = p;
            return p;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int k = (i+1)%values.length;
        int min = Integer.MAX_VALUE;
        while(k!=j){
            int score1 = values[i]*values[j]*values[k];
            int score2 = dfs(i,k,values);
            int score3 = dfs(k,j,values);
            min = Math.min(min,score1+score2+score3);
            k = (k+1)%values.length;
        }
        dp[i][j] = min;
        return min;
    }


    public int minScore(long bitmap, int count, int[] values) {
        //如果位图上的点为3个，直接返回结果
        if (map.containsKey(bitmap)) {
            return map.get(bitmap);
        }
        if (count == 3) {
            //找到三个点

            for (int i = 0; i < values.length; i++) {
                if (((bitmap >> i) & 1) == 1) {
                    int product = pos2Product(i, bitmap, values);
                    map.put(bitmap, product);
                    return product;
                }
            }


        } else {
            //要是多个点，提取一个点做分割，返回最小值
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < values.length; i++) {
                if (((bitmap >> i) & 1) == 1) {
                    //要是我提取这个点，就得将该点对应的位图置0
                    long newbitmap = bitmap ^ (1L << i);
                    int score1 = minScore(newbitmap, count - 1, values);
                    int score2 = pos2Product(i, bitmap, values);
                    if (score1 + score2 < min) {
                        min = score1 + score2;
                    }
                }
            }
            map.put(bitmap, min);
            return min;
        }
        return 0;
    }

    public int pos2Product(int pos, long bitmap, int[] values) {
        int p1 = (pos - 1 + values.length) % values.length;
        int p2 = (pos + 1) % values.length;
        while (((bitmap >> p1) & 1) == 0) {
            p1 = (p1 - 1 + values.length) % values.length;
        }
        while (((bitmap >> p2) & 1) == 0) {
            p2 = (p2 + 1 + values.length) % values.length;
        }
        return values[pos] * values[p1] * values[p2];
    }


    public static void main(String[] args) {
        leetcode_1039 demo = new leetcode_1039();
        demo.minScoreTriangulation(new int[]{3, 7, 4, 5});
    }
}
