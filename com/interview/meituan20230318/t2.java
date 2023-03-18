package com.interview.meituan20230318;

import java.util.*;

public class t2 {

    public static void main(String[] args) {
        //颜色 颜色最后的位置
        HashMap<Integer,Integer> map = new HashMap<>();
        //现有的颜色
        HashSet<Integer> picked = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        //输入量
        int n = sc.nextInt();
        //颜色上限
        int k = sc.nextInt();

        int maxl = 0;
        int head = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if(picked.contains(temp)){
                map.put(temp,i);
                maxl = Math.max(maxl,i-head+1);
            }else{
                if(picked.size()<k){
                    picked.add(temp);
                    map.put(temp,i);
                    maxl = Math.max(maxl,i-head+1);
                }else{
                    int cur = 0;
                    int min = Integer.MAX_VALUE;
                    maxl = Math.max(maxl,i-head);
                    for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                        if(integerIntegerEntry.getValue()<min){
                            min = integerIntegerEntry.getValue();
                            cur = integerIntegerEntry.getKey();
                        }
                    }
                    picked.add(temp);
                    map.put(temp,i);
                    picked.remove(cur);

                    head = cur+1;

                }
            }
        }

        System.out.println(maxl);



    }
}
