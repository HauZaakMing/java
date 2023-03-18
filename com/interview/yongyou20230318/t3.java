package com.interview.yongyou20230318;

import java.util.Stack;

public class t3 {

    public boolean isPopOrder (int[] pushSequence, int[] popSequence) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int length = pushSequence.length;
        int cur = 0;
        for (int i = 0; i < length ; i++) {

            stack.push(pushSequence[i]);

            while (!stack.isEmpty()&&stack.peek()==popSequence[cur]){
                stack.pop();
                cur++;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        t3 demo = new t3();
        demo.isPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }
}
