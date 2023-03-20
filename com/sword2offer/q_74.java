package com.sword2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class q_74 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(Comparator.comparingInt(o -> o[0])));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int ns = intervals[i][0];
            int ne = intervals[i][1];
            if(ns<=end){
                end = Math.max(end,ne);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                ans.add(list);

                start = ns;
                end = ne;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        ans.add(list);
        int [][]ans1 = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ArrayList<Integer> list1 = ans.get(i);
            ans1[i][0] = list1.get(0);
            ans1[i][1] = list1.get(1);
        }
        return ans1;
    }
}
