package com.zuoshen;

import java.util.ArrayList;

public class p11_package {

    public static int packV(ArrayList<Node> list, int[][] dp, int bagCapacity, int N) {

        for (int i = 1; i <= bagCapacity; i++) {
            for (int j = 1; j < N; j++) {
                if (list.get(j).weight <= i) {
                    dp[i][j] = Math.max(dp[i - list.get(j).weight][j - 1] + list.get(j).value, dp[i][j - 1]);
                }
            }
        }

        return dp[bagCapacity][N - 1];
    }

    public static void main(String[] args) {
        int[] values = { 10, 2, 4, 5 };
        int[] weights = { 7, 4, 5, 8 };
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            Node n = new Node(values[i], weights[i]);
            list.add(n);
        }
        list.sort(null);
        int bagCapacity = 20;
        int[][] dp = new int[bagCapacity + 1][values.length];
        System.out.println(packV(list, dp, bagCapacity, values.length));
    }
}

class Node implements Comparable<Node> {
    int value;
    int weight;

    public Node(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node n) {
        // TODO Auto-generated method stub
        return this.weight - n.weight;
    }
}
