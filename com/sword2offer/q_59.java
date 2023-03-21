package com.sword2offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class q_59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();

        int ans[] = new int[nums.length-k+1];

        int l = 0;
        int r = 0;
        while (r<nums.length){
            if(l>0){
                if(queue.peekFirst()==l-1){
                    queue.poll();
                }
            }
            if(queue.isEmpty()){
                queue.add(r);
            }else{
                while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[r]){
                    queue.pollLast();
                }
                queue.addLast(r);
            }
            r++;
            ans[l] = nums[queue.peekFirst()];
            if(r>=k){
                l++;
            }

        }

        return ans;
    }
}
