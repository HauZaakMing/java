package com.interview.yitu20230401;

import java.util.*;

public class t5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            nums.add(Math.abs(temp));
            if(pos.containsKey(temp)){
                ArrayList<Integer> list = pos.get(temp);
                list.add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                pos.put(temp,list);
            }
        }
        int ans = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                if(nums.get(i)>=nums.get(j)){
                    continue;
                }else{
                    for (int k = nums.get(i)+1; k < nums.get(j) ; k++) {
                        if(pos.containsKey(k)){
                            List<Integer> list = pos.get(k);
                            for (int l = list.size()-1; l >= 0 ; l--) {
                                if(list.get(l)<j){
                                    break;
                                }else{
                                    ans++;
                                    ans = ans%100000007;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
