package com.sword2offer;

public class q_092 {
    //剑指 Offer II 092. 翻转字符
    public int minFlipsMonoIncr(String s) {
        int pos = 0;
        while (s.charAt(pos)=='0'){
            pos++;
        }
        s = s.substring(pos,s.length());
        int zero_count = 0;
        int one_count = 0;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c=='0'){
                zero_count++;
            }else{
                one_count++;
            }
        }
        //开始寻找翻转点
        int ans = Integer.MAX_VALUE;

        int left_one = 0;
        int right_zero = zero_count;

        for (int i = 0; i < s.length() ; i++) {
            int op = left_one+right_zero;
            if(op<ans){
                ans = op;
            }
            if(s.charAt(i)=='1'){
                left_one++;
            }else{
                right_zero--;
            }
        }
        int op = left_one+right_zero;
        if(op<ans){
            ans = op;
        }
        return ans;

    }
}
