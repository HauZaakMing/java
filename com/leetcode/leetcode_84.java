package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode_84 {

    //84. 柱状图中最大的矩形
    public int largestRectangleArea(int[] heights) {

        int []lP = new int[heights.length];
        int []rP = new int[heights.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while (!stack.isEmpty()&&heights[i]<heights[stack.peekLast()]){
                    rP[stack.pollLast()] = i-1;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            rP[stack.pollLast()] = heights.length-1;
        }

        for (int i = heights.length-1; i >= 0; i--) {
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while (!stack.isEmpty()&&heights[i]<heights[stack.peekLast()]){
                    lP[stack.pollLast()] = i+1;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            lP[stack.pollLast()] = 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(heights[i]*(rP[i]-lP[i]+1),max);
        }
        return max;
    }

    public static void main(String[] args) {
        leetcode_84 demo = new leetcode_84();
        demo.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
}
