package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode_84 {

    //84. 柱状图中最大的矩形
    public int largestRectangleArea1(int[] heights) {

        int []lP = new int[heights.length];
        int []rP = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while (!stack.isEmpty()&&heights[i]<heights[stack.peekFirst()]){
                    rP[stack.pollFirst()] = i-1;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            rP[stack.pollFirst()] = heights.length-1;
        }

        for (int i = heights.length-1; i >= 0; i--) {
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while (!stack.isEmpty()&&heights[i]<heights[stack.peekFirst()]){
                    lP[stack.pollFirst()] = i+1;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            lP[stack.pollFirst()] = 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(heights[i]*(rP[i]-lP[i]+1),max);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int newHeights[] = new int[heights.length+2];
        newHeights[0] = 0;
        newHeights[newHeights.length-1] = 0;
        System.arraycopy(heights,0,newHeights,1,heights.length);
        heights = newHeights;
        stack.addLast(0);
        int ans = 0;
        for (int i = 1; i < heights.length; i++) {

            while (heights[i]<heights[stack.peekLast()]){
                int cur_height = heights[stack.pollLast()];
                int cur_width = i-stack.peekLast()-1;
                if(cur_height*cur_width>ans){
                    ans = cur_height*cur_width;
                }
            }
            stack.addLast(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        leetcode_84 demo = new leetcode_84();
        demo.largestRectangleArea(new int[]{2,4});
    }
}
