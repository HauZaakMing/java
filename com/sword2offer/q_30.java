package com.sword2offer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class q_30 {
    //剑指 Offer 30. 包含min函数的栈

}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            if(x<minStack.peek()){
                minStack.push(x);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}