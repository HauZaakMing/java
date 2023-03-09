package com.leetcode;

import java.util.PriorityQueue;
import java.util.Random;

public class leetcode_215 {

    public int findKthLargest1(int[] nums, int k) {
        //用堆来解决的话，主要看k的大小，不一定能做到O(n)
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1,o2)->o2-o1);

        for (int num :
                nums) {
            queue.add(num);
        }
        int ans = Integer.MAX_VALUE;
        while (k>0){
            k--;
            ans = queue.poll();
        }
        return ans;
    }

    public int findKthLargest(int[] nums, int k) {
        return partition(nums,k-1,0,nums.length-1);
    }

    public static int partition(int []nums,int targetP,int left,int right){
        //我只需要知道第k大，那我只要k前面全小于k，k后面全小于k就好了
        int p1 = left-1;
        int p2 = right+1;
        int target = nums[left];
        int curp = left;
        while(curp<p2){
            if(nums[curp]==target){
                curp++;
            }else if(nums[curp]>target){
                p1 = p1+1;
                swap(nums,p1,curp);
                curp ++;
            }else{
                p2 = p2-1;
                swap(nums,p2,curp);

            }
        }
        if(targetP>p1&&targetP<p2){
            return target;
        }else if (targetP<=p1){
            return partition(nums,targetP,left,p1);
        }else{
            return partition(nums,targetP,p2,right);
        }
    }

    public static void swap(int []num,int p1,int p2){
        int temp = num[p2];
        num[p2] = num[p1];
        num[p1] = temp;

    }

    public static void main(String[] args) {
        leetcode_215 demo = new leetcode_215();
        demo.findKthLargest(new int[]{7,6,5,4,3,2,1},2);
    }
}
