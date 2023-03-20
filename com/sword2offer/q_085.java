package com.sword2offer;

import java.util.ArrayList;
import java.util.List;

public class q_085 {
    public ArrayList<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,n,0,"");
        return list;
    }
    //pos           当前处于第几个字符
    //already       当前以选用多少个左括号
    //String        当前形成的字符串
    public void dfs(int pos,int n,int already,String s){
        if(pos==2*n){
            list.add(s);
        }

        //两种选择，加入左括号，或者加入右括号
        if(already<n){
            dfs(pos+1,n,already+1,s+"(");
        }
        if((pos-already)<already){
            dfs(pos+1,n,already,s+")");
        }
    }
}
