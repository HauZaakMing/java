package com.leetcode;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class leetcode_2363 {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int[] list : items1) {
            if (!m.containsKey(list[0])) {
                m.put(list[0], list[1]);
            } else {
                m.put(list[0], m.get(list[0]) + list[1]);
            }
        }
        for (int[] list : items2) {
            if (!m.containsKey(list[0])) {
                m.put(list[0], list[1]);
            } else {
                m.put(list[0], m.get(list[0]) + list[1]);
            }
        }
        Set<Integer> keys = m.keySet();
        for (Integer key : keys) {
            int value = m.get(key);
            List<Integer> l = new ArrayList<>();
            l.add(key);
            l.add(value);
            ans.add(l);
        }
        return ans;
    }
}
