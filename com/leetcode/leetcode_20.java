package com.leetcode;

import java.util.Stack;

public class leetcode_20 {
    public static char kuohao[][] = new char[][]{{'(',')'},{'{','}'},{'[',']'}};
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars =  s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(stack.isEmpty()){
                stack.add(chars[i]);
            }else{
                boolean flag = false;
                for (char []k:
                     kuohao) {
                    if(stack.peek().equals(k[0])&&chars[i]==k[1]){
                        stack.pop();
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    stack.push(chars[i]);
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        leetcode_20 demo = new leetcode_20();
        demo.isValid("()");
    }
}
