package com.zuoshen;

import java.util.Stack;

public class p11_recurStack {

    public static void rStack(Stack<Integer> s) {
        if (s.size() == 1) {
            return;
        }
        int top = s.pop();
        rStack(s);
        s.push(top);

    }

    public static int f(Stack<Integer> s) {
        if (s.size() == 1) {
            return s.pop();
        } else {
            int temp = s.pop();
            int result = f(s);
            s.push(temp);
            return result;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        rStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
