package com.sword2offer;

import java.util.PriorityQueue;

public class q_005 {

    //剑指 Offer II 005. 单词长度的最大乘积
    public int maxProduct(String[] words) {
//        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.size= o1.size);
        int ans = 0;
        int state[] = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            state[i] = getState(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 1; j < words.length ; j++) {
                int state1 = state[i];
                int state2 = state[j];
                if((state1&state2)==0){
                    int temp = words[i].length()*words[j].length();
                    if(temp>ans){
                        ans = temp;
                    }
                }
            }

        }
        return ans;
    }

    public int getState(String s){
        int state = 0;
        for (char c : s.toCharArray()) {
            int temp = c-'a';
            state = state|(1<<temp);
        }
        return state;
    }

}

class Node{
    int state;
    int size;

    public Node(int state, int size) {
        this.state = state;
        this.size = size;
    }
}
