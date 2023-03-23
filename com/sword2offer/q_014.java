package com.sword2offer;

import java.util.HashMap;
import java.util.HashSet;

public class q_014 {
    //剑指 Offer II 014. 字符串中的变位词
    public boolean checkInclusion(String s2, String s1) {
        int []check = new int[26];
        HashSet<Character> set= new HashSet<>();

        for (int i = 0; i < s2.length(); i++) {
            check[s2.charAt(i)-'a']++;
            set.add(s2.charAt(i));
        }
        for (int i = 0; i < s1.length(); i++) {
            if(i>=s2.length()&&set.contains(s1.charAt(i-s2.length()))){
                check[s1.charAt(i-s2.length())-'a']++;
            }
            char c = s1.charAt(i);
            if(set.contains(c)){
                check[c-'a']--;
            }
            if(checkNum(check)){
                return true;
            }
        }
        return false;

    }

    public boolean checkNum(int []nums){

        for (int i =  0; i < nums.length ; i++) {
            if(nums[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        q_014 demo = new q_014();
        demo.checkInclusion("a","ab");
    }
}
