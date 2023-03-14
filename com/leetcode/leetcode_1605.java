package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_1605 {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int [][]ans = new int[rowSum.length][colSum.length];
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.count-o2.count));
        for (int i = 0; i < rowSum.length; i++) {
            Node node = new Node(i,rowSum[i]);
            queue.add(node);
        }
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int pos = node.pos;
            int count = node.count;
            for (int i = 0; i < colSum.length; i++) {
                int temp = Math.min(count,colSum[i]);
                ans[pos][i] = temp;
                count-=temp;
                colSum[i]-=temp;
            }
        }
        return ans;


    }

    class Node{
        int pos;
        int count;

        public Node(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }
}
