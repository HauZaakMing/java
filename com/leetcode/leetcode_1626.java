package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;

public class leetcode_1626 {
    //1626. 无矛盾的最佳球队
    ArrayList<Node> list;
    public int ans;
    int dp[];

    public int bestTeamScore(int[] scores, int[] ages) {
        list = new ArrayList<>();
        dp = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            Node node = new Node(ages[i], scores[i]);
            list.add(node);
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.age != o2.age) {
                    return o1.age - o2.age;
                } else {
                    return o1.score - o2.score;
                }

            }
        });
        ans = 0;

        for (int i = 0; i < scores.length ; i++) {
            Node node = list.get(i);
            int score = node.score;
            int max = 0;
            for (int j = i-1 ; j >= 0 ; j--) {
                if(list.get(j).score<=node.score){
                    max= Math.max(max,dp[j]);
                }
            }
            dp[score] =max+score;
            ans = Math.max(ans,dp[score]);

        }
        return ans;
    }

//    public void dfs(int pos, int maxAge, int maxScore, int sum) {
//
//        //推出条件
//        if (pos == list.size()) {
//            if (sum > ans) {
//                ans = sum;
//            }
//            return;
//        }
//
//        if(visited[pos][maxScore]){
//            return;
//        }
//
//        //选择进去
//        int age = list.get(pos).age;
//        int score = list.get(pos).score;
//        if (age == maxAge){
//            dfs(pos+1,maxAge,score,sum+score);
//        }else{
//            if(score>=maxScore){
//                dfs(pos+1,age,score,sum+score);
//            }
//        }
//        //不要
//        dfs(pos+1,maxAge,maxScore,sum);
//        visited[pos][maxScore] = true;
//    }

    class Node {
        int age;
        int score;

        public Node(int age, int score) {
            this.age = age;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        leetcode_1626 demo = new leetcode_1626();
        demo.bestTeamScore(new int[]{1,1,1,1,1,1,1,1,1,1},new int[]{811,364,124,873,790,656,581,446,885,134});
    }
}


