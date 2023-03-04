package com.leetcode;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode_989 {

    public List<Integer> addToArrayForm(int[] num, int k) {
        Deque<Integer> ans = new LinkedList<>();
        int next = 0;
        int i = num.length-1;
        for (; i >=0 ; i--) {
            int cur = num[i]+next+k%10;
            next = cur/10;
            ans.addFirst(cur%10);
            k=k/10;
            if(k==0){
                i--;
                break;
            }
        }
        while (i>=0){
            int cur = num[i]+next;
            ans.addFirst(cur%10);
            next = cur/10;
            i--;
        }

        while(k>0){
            int cur = k%10+next;
            next = cur/10;
            ans.addFirst(cur%10);
            k=k/10;
        }
        if(next>0){
            ans.addFirst(next);
        }
        return (List<Integer>) ans;
    }

    public static void main(String[] args) {
        leetcode_989 demo = new leetcode_989();
        demo.addToArrayForm(new int[]{2,7,4},181);
    }

}
