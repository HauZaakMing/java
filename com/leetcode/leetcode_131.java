package com.leetcode;

import com.sun.jdi.Value;
import org.junit.Test;

import java.util.*;

public class leetcode_131 {

    List<List<String>> ans;
//    HashMap<Integer,List<List<Integer>>> map;
    boolean dp[][];

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        dp = new boolean[s.length()][s.length()];
//        map = new HashMap<>();
        recur(0,s,new ArrayList<>());
        return ans;
    }

    public void recur(int pos,String s,ArrayList<String> cur){
        if(pos == s.length()){
            List<String> copy = (ArrayList<String>)cur.clone();

            ans.add(copy);
        }
//        if(map.containsKey(pos)){
//            return map.get(pos);
//        }
//        List<List<String>> cur = new LinkedList<>();
        for (int i = 1; i+pos <= s.length() ; i++) {
            if(dp[pos][pos+i]||check(s.substring(pos,pos+i))){
                dp[pos][pos+i] = true;
                cur.add(s.substring(pos,pos+i));
                recur(pos+i,s,cur);
                cur.remove(cur.size()-1);
            }

        }


    }

    public boolean check(String s){
        char chars[] = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len/2; i++) {
            if(chars[i]!=chars[len-i-1]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        leetcode_131 demo = new leetcode_131();
        demo.partition("cbbbcc");
    }
}
