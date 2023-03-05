package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class leetcode_6310 {

    public int waysToReachTarget(int target, int[][] types) {
        Comparator<int []> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        };
        Arrays.sort(types,c);
        int [][] dp = new int[target+1][types.length+1];
        for (int i = 0; i <dp.length; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        return dfs(target,types,0,dp);




    }


    public int dfs(int target, int[][] types,int pos,int[][] dp){
        int ans = 0;
        if(pos==types.length){
            dp[target][pos] = 0;
            return 0;
        }
        //选择某位置的数字用多少个
        int max = types[pos][0];
        int val = types[pos][1];
        //可以选择该位置取0个，最多取到max个，但是要是取多了，target都为付了，就没必要往下找了
        for (int i = 0; i <= max; i++) {
            int last = target -i*val;
            if(last == 0){
//                System.out.println("val = " + val);
//                System.out.println("i = " + i);
                ans ++;
                break;
            }else if(last<0){
                break;
            }else {//要是last还是>0，看看后面还有没有数字

                if (dp[last][pos + 1] != Integer.MAX_VALUE) {
                    ans += dp[last][pos + 1];
                } else {
                    int temp = dfs(last, types, pos + 1, dp);
                    dp[last][pos + 1] = temp;
                    ans += temp;
                }
                ans = (int) (ans % (1e9 + 7));
            }



        }


        return ans;
    }


    public static void main(String[] args) {
        int [][]nums = new int[][]{{6,1},{3,2},{2,3}};
        leetcode_6310 demo = new leetcode_6310();
        System.out.println(demo.waysToReachTarget(6,nums));
    }
}
