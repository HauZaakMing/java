package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class leetcode_1096 {



    TreeSet<String> s = new TreeSet<>();
    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(s);
    }

    public void dfs(String str){
        int firstRB = str.indexOf('}');
        if(firstRB==-1){
            s.add(str);
            return;
        }
        int LBpos = firstRB-1;
        while (LBpos>=0&&str.charAt(LBpos)!='{'){
            LBpos--;
        }
        for (String s:
             str.substring(LBpos+1,firstRB).split(",")) {
            String next = str.substring(0,LBpos)+s+str.substring(firstRB+1);
            dfs(next);
        }
    }

//
    public static void main(String[] args) {
        leetcode_1096 demo = new leetcode_1096();
        demo.braceExpansionII("{{a,z},a{b,c},{ab,z}}");
        System.out.println("hi");
    }
}
