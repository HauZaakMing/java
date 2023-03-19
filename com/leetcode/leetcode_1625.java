package com.leetcode;

import java.util.HashSet;

public class leetcode_1625 {
    HashSet<String> visited;
    String minS;
    public String findLexSmallestString(String s, int a, int b) {
        visited = new HashSet<>();
        visited.add(s);
        minS = s;
        dfs(s,a,b);
        return minS;
    }

    public void dfs(String s,int a,int b){


        if(minS.compareTo(s)>0){
            minS = s;
        }
        String s1 = goRound(s,b);
        String s2 = addOdd(s,a);
        if(!visited.contains(s1)){
            visited.add(s1);
            dfs(s1,a,b);

        }
        if(!visited.contains(s2)){
            visited.add(s2);
            dfs(s2,a,b);

        }



    }

    public String goRound(String s,int b){
        int length = s.length();
        int trueR = b%length;
        String subStringP = s.substring(s.length()-trueR,s.length());
        String subStringS = s.substring(0,s.length()-trueR);
        return subStringP+subStringS;

    }

    public String addOdd(String s,int a){
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==1){
                int temp = chars[i]-'0';
                temp = (temp+a)%10;
                chars[i] = (char) (temp+'0');

            }
        }
        String sRe = String.valueOf(chars);
        return sRe;
    }

    public static void main(String[] args) {
        leetcode_1625 demo = new leetcode_1625();
        demo.findLexSmallestString("43987654",7,3);
    }
}
