
package com.interview;

import java.util.HashSet;
import java.util.Stack;

public class heightList {

    public int getGroup(int[] heights) {

        int l = heights.length;
        HashSet<Integer> group = new HashSet<>();

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < l; i++) {
            if (s.isEmpty()) {
                s.add(i);
            } else {
                while (!s.isEmpty() && heights[i] < heights[s.peek()]) {// 当小于栈顶元素，开始跳
                    group.add(i - s.peek());

                    s.pop();
                }
                s.add(i);
            }
        }
        if (!s.isEmpty()) {
            return group.size() + 1;
        } else {
            return group.size();
        }

        // return group.size();

    }

    public static void main(String[] args) {
        heightList hl = new heightList();
        System.out.println(hl.getGroup(new int[] { 165, 175, 165, 180, 153, 170 }));
    }

}
