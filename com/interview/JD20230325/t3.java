package com.interview.JD20230325;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class t3 {
    public static int max[];
    public static int group[];
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        max = new int[n+1];
        group = new int[n+1];
        //初始化max数组
        //初始化并查集
        for (int i = 1; i <= n ; i++) {
            max[i] = sc.nextInt();
            group[i] = i;
        }
        //简历连接集,只存比自己小的next
        HashMap<Integer, ArrayList<Integer>> ada = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            //要令a>b
            if(a<b){
                int temp = a;
                a = b;
                b = temp;
            }
            if(ada.containsKey(a)){
                ArrayList<Integer> list = ada.get(a);
                list.add(b);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(b);
                ada.put(a,list);
            }


        }
        int max_cur = max[1];
        System.out.println(max_cur);
        for (int i = 2; i <= n ; i++) {
            ArrayList<Integer> list = ada.get(i);
            //收集可以连通的节点，我自己当根
            int temp = max[i];
            if(list==null){
                max_cur = Math.max(max[i],max_cur);
                System.out.println(max_cur);
                continue;
            }
            HashSet<Integer> visited = new HashSet<>();
            for (Integer num :
                    list) {
                //找该节点的root
                if(visited.contains(num)){
                    continue;
                }
                ArrayList<Integer> need2change = new ArrayList<>();
                while(group[num]!=num){
                    visited.add(num);
                    need2change.add(num);
                    num = group[num];
                }
                for (Integer a :
                        need2change) {
                    group[a] = i;
                }
                //要是刚刚拿过就跳
                if(num==i){
                    continue;
                }
                //获得其所在群的总值
                temp += max[num];
                //然后修改这个群号
                group[num] = i;
            }
            max[i] = temp;
            if(max[i]>max_cur){
                max_cur = max[i];
                System.out.println(max[i]);
            }else{
                System.out.println(max_cur);
            }

        }
    }


}


