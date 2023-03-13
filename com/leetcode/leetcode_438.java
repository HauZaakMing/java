package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_438 {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length()<p.length()){
            return ans;
        }

        int differ[] = new int[26];
        int zeros[] = new int[26];
        for (int i = 0; i < p.length(); i++) {
            differ[(int)(p.charAt(i)-'a')] ++;
        }
        for (int i = 0; i < p.length(); i++) {
            differ[(int)(s.charAt(i)-'a')]--;

        }
        if(Arrays.equals(differ,zeros)){
            ans.add(0);
        }
        for (int i = p.length(); i < s.length() ; i++) {
            differ[(int)(s.charAt(i)-'a')]--;
            differ[(int)(s.charAt(i-p.length())-'a')]++;
            if(Arrays.equals(differ,zeros)){
                ans.add(i-p.length()+1);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        leetcode_438 demo = new leetcode_438();
        demo.findAnagrams("cbaebabacd","abc");
    }

}
