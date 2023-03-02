package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class leetcode_2572 {

    class Node {
        // 已经选取的数组，选取则该位为1
        int pick;
        // 相当于一个check，只有对应位置为1，才可以进来
        int statecode;
        // 当前集合的组合个数
        int count;

        public Node(int pick, int statecode, int count) {
            this.pick = pick;
            this.statecode = statecode;
            this.count = count;

        }
    }

    public int squareFreeSubsets(int[] nums) {
        int ans = 0;
        // 首先通过打表，生成1-30谁跟谁不能混在一起，生成状态码
        int[] check = new int[31];

        HashSet<Integer> no = new HashSet<>();
        no.add(4);
        no.add(8);
        no.add(12);
        no.add(20);
        no.add(24);
        no.add(28);
        no.add(9);
        no.add(18);
        no.add(27);
        no.add(16);
        no.add(25);

        for (int i = 1; i < check.length; i++) {
            for (int j = 1; j < check.length; j++) {
                boolean flag = true;
                if (no.contains(i) || no.contains(j)) {

                    break;
                }
                for (int k = 2; k <= Math.min(i, j); k++) {
                    if (i % k == 0 && j % k == 0) {
                        flag = false;
                        break;
                    }

                }
                if (flag) {
                    check[i] = check[i] | (1 << (j - 1));
                }

            }
        }
        // 统计每种数字的个数
        int[] m = new int[31];
        for (int num : nums) {
            m[num]++;
        }

        // 这个队列用来存放所有能够用来扩展的集合
        LinkedList<Node> l = new LinkedList<>();

        Node head = new Node(0, (1 << 31) - 1, 1);
        HashSet<Integer> pickS = new HashSet<>();
        // 先把单个元素能用的载如到等待扩容集合里
        l.add(head);
        while (!l.isEmpty()) {
            Node n = l.poll();
            int pick = n.pick;
            int statecode = n.statecode;
            int count = n.count;
            for (int i = 1; i <= 30; i++) {
                if (m[i] == 0 || no.contains(i)) {
                    continue;
                }
                // 未被选取的,且可被选取
                if (((pick >> i) % 2) == 0 && (statecode >> i) % 2 == 1) {
                    int newPick = pick | (1 << i);
                    if (pickS.contains(newPick)) {
                        continue;
                    }
                    pickS.add(newPick);
                    int newStatecode = statecode | check[i];
                    int newCount = count * m[i];
                    Node nNode = new Node(newPick, newStatecode, newCount);

                    if (newStatecode != 0) {
                        l.add(nNode);
                    }
                    ans = ans + (int) (newCount % (1e9 + 7));
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        leetcode_2572 demo = new leetcode_2572();
        demo.squareFreeSubsets(new int[] { 11, 2, 19, 7, 9, 27 });
    }
}
