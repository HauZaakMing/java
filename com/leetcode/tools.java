package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tools {


    //判断两个数字是否互质   互余再余余数
    public boolean gca (int a ,int b){
        boolean flag = true;

        int t = a%b;
        while(t!=0){
            a=b;
            b=t;
            t=a%b;
        }
        return b==1;
    }

    //欧拉筛法，获得2到maxN的所有指数
    public static List<Integer> getPrimeL(int maxN){
        List<Integer> pl = new ArrayList<>();
        boolean []isprime = new boolean[maxN];
        Arrays.fill(isprime,true);
        isprime[1] = false;
        for (int i = 2; i < maxN; i++) {
            if(isprime[i]){
                pl.add(i);
            }
            for (int j = 0; j < pl.size() && i*pl.get(j)<maxN ; j++) {
                isprime[i*pl.get(j)] = false;
                if(i%pl.get(j)==0) break;
            }

        }
        return pl;
    }


}
