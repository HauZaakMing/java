package com.leetcode;

import java.util.*;

public class leetcode_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //dfs递归搜索
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
//        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));




        ans = dfs(candidates, candidates.length - 1, target);


        return ans;
    }

    public List<List<Integer>> dfs(int []nums, int pos, int target ){

        List<List<Integer>> ans = new ArrayList<>();
        if(pos<0||target<nums[0]){
            return ans;
        }
        int times = target/nums[pos];
        for (int i = times; i >= 0; i--) {
            //i决定放几个pos位置的元素进去
            List<Integer> head = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                head.add(nums[pos]);
            }
            int last = target-nums[pos]*i;
            if(last == 0){
                ans.add(head);

            }else{
                List<List<Integer>> temp = dfs(nums,pos-1,last);
                for (int j = 0; j < temp.size(); j++) {
                    List<Integer> l1 = temp.get(j);
                    List<Integer> lM = listMerge(head,l1);
                    ans.add(lM);
                }
            }

        }
        return ans;
    }

    public <T> List<T> listMerge(List<T> l1, List<T> l2){
        List<T> lAll = new ArrayList<>();
        lAll.addAll(l1);
        lAll.addAll(l2);
        return lAll;
    }


    public static void main(String[] args) {
        leetcode_39 demo = new leetcode_39();
        demo.combinationSum(new int[]{2,3,6,7},7);
    }
}
