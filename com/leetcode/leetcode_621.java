package com.leetcode;

import java.util.*;

public class leetcode_621 {

    public int leastInterval1(char[] tasks, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(((o1, o2) -> o2-o1));
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c :
                tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer value = characterIntegerEntry.getValue();
            queue.add(value);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
//            int min = Integer.MAX_VALUE;
            int size = queue.size();
            // 提取现有任务，尽可能在n+1时间内塞满
            for (int i = 0; i <= n&&(!queue.isEmpty()); i++) {
                int num = queue.poll();

                temp.add(num);
            }
            for (int num:
                 temp) {
                if(num-1>0){
                    queue.add(num-1);
                }
            }
            if(!queue.isEmpty()){
                ans+=n+1;
            }else{
                ans+=size;
            }

        }



        return ans;

    }

    public int leastInterval(char[] tasks, int n) {
        //采用桶装思维，我们最大值影响轮次，剩下就是往桶里填值
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        leetcode_621 demo = new leetcode_621();
        demo.leastInterval(new char[]{'A','A','A','B','B','B','C','C','C','D','D','E'},2);
    }
}
