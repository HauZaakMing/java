package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_93 {

    public static ArrayList<String> ans;
     //i pos j k
    public static boolean check[][];

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        check = new boolean[s.length()][4];
        for (int i = 0; i < check.length; i++) {
            Arrays.fill(check[i],true);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 4; j++) {
                if((s.length()-i)/(double)(4-j)>3){
                    check[i][j] = false;
                }
            }
        }
        dfs(0,s,"",0);
        return ans;
    }

    public static boolean dfs(int pos,String s,String curS,int k){
        if(pos==s.length()){
            if(k==4){
                ans.add(curS.substring(0,curS.length()-1));
                return true;
            }else{
                return false;
            }

        }
        if(k==4&&pos<s.length()){
            return false;
        }

        if (!check[pos][k]){
            return false;
        }
        boolean flag = false;
        for (int i = 1; i < 4 && pos+i <= s.length(); i++) {
            String tempS = s.substring(pos,pos+i);
            //head zero
            if(i!=1&&tempS.charAt(0)=='0'){
                continue;
            }
            //<=255
            if(Integer.valueOf(tempS)>255){
                break;
            }
            flag = flag|dfs(pos+i,s,curS+tempS+".",k+1);
        }
        check[pos][k] = flag;
        return flag;
    }

    public static void main(String[] args) {
        leetcode_93 demo = new leetcode_93();
        demo.restoreIpAddresses("25525511135");
    }
}
