package com.leetcode;

import java.util.HashMap;

public class leetcode_76 {

    public String minWindow(String s, String t) {
        //先统计t的字符
        char[] charsT = t.toCharArray();
        HashMap<Integer,Integer> tmap = new HashMap<>();
        for (int i = 0; i < charsT.length; i++) {
            tmap.put(charsT[i]-'A', tmap.getOrDefault(charsT[i]-'A',0)+1);
        }
        char[] charsS = s.toCharArray();
        int p1 = 0;
        HashMap<Integer,Integer> Smap = new HashMap<>();
        boolean flag = false;
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < charsS.length ; i++) {
            if(tmap.containsKey(charsS[i]-'A')){
                Smap.put(charsS[i]-'A', Smap.getOrDefault(charsS[i]-'A',0)+1);


                //检查一下是否满足
                if(!flag){
                    //先检查长度是否合适
                    if (i-p1+1>=t.length()){
                        //长度合适就可以比对里面的内容了
                        boolean f = true;
                        for (int j = 0; j <=57 ;j++) {
                            int t1 = Smap.getOrDefault(j,0);
                            int t2 = tmap.getOrDefault(j,0);
                            if(t1<t2){
                                f = false;
                                break;
                            }
                        }
                        if(f){
                            flag =true;
                            while (!tmap.containsKey(charsS[p1]-'A')||Smap.get(charsS[p1]-'A')>tmap.get(charsS[p1]-'A')){
                                if(tmap.containsKey(charsS[p1]-'A')){
                                    Smap.put(charsS[p1]-'A',Smap.get(charsS[p1]-'A')-1);
                                }
                                p1++;
                            }
                            minLen = i-p1+1;
                            ans = s.substring(p1,i+1);
                        }
                    }
                }else{
                    while (!tmap.containsKey(charsS[p1]-'A')||Smap.get(charsS[p1]-'A')>tmap.get(charsS[p1]-'A')){
                        if(tmap.containsKey(charsS[p1]-'A')){
                            Smap.put(charsS[p1]-'A',Smap.get(charsS[p1]-'A')-1);
                        }
                        p1++;
                    }
                    if((i-p1+1)<minLen){
                        minLen = i-p1+1;
                        ans = s.substring(p1,i+1);
                    }
                }

            }
        }
        return ans;

    }

    public static void main(String[] args) {
        leetcode_76 demo = new leetcode_76();
        demo.minWindow("ADOBECODEBANC","ABC");
    }
}
