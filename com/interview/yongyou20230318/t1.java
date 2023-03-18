package com.interview.yongyou20230318;

import java.util.ArrayList;
import java.util.Arrays;

public class t1 {

    public String[] toByteArray (int value) {

        // write code here
        int yushu = value%128;
        int count =0;

        while(value>=128){
            value = value/128;
            if(value>=1){
                count++;
            }else{
                break;
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        //当余数不为0
        if(yushu!=0){
            if(count>0){
                ans.add(Integer.toString(yushu+80));
            }else{
                ans.add(Integer.toString(yushu));
            }
        }
        if(count>0){
            for (int i = 0; i < count; i++) {
                ans.add("80");
            }
        }
        if(value>0&&count>0){
            ans.add(Integer.toString(value));
        }
        String re[] = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            re[i] = ans.get(i);
        }
        return re;
    }

    public static void main(String[] args) {
        t1 demo = new t1();
        demo.toByteArray(1);
    }
}
