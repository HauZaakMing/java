package com.sword2offer;

import java.util.Stack;

public class q_09 {


}


class CQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackBackUp;
    public CQueue() {
        stackIn = new Stack<>();
        stackBackUp = new Stack<>();
    }

    public void appendTail(int value) {
        stackIn.add(value);
    }

    public int deleteHead() {
        int head = 0;
        if(stackIn.size()==0){
            return -1;
        }else{
            int length = stackIn.size();
            for (int i = 0; i < length; i++) {

                stackBackUp.push(stackIn.pop());
            }
            head = stackBackUp.pop();
            length = stackBackUp.size();
            for (int i = 0; i < length; i++) {
                stackIn.push(stackBackUp.pop());
            }
        }
        return head;
    }
}