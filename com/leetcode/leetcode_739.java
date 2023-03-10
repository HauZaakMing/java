package com.leetcode;

import com.sun.nio.sctp.AssociationChangeNotification;

import java.util.Stack;

public class leetcode_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int []ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if(stack.isEmpty()){
                stack.add(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    int pos = stack.pop();
                    ans[pos] = i-pos;
                }
                stack.add(i);
            }

        }
        return ans;
    }
}
