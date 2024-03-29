package com.leetcode;

import java.util.HashMap;

public class leetcode_3 {
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] allc = s.toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();

        int ans = 0;
        int currentS = 0;
        int currentE = 0;
        while (currentE < allc.length) {
            if (!m.containsKey(allc[currentE])) {
                m.put(allc[currentE], currentE);

                ans = Math.max(ans, (currentE - currentS) + 1);
                currentE = currentE + 1;
            } else {
                int pos = m.get(allc[currentE]);

                // 需要把新start前的字符清出map
                for (int i = currentS; i <= pos; i++) {
                    m.remove(allc[i]);
                }
                m.put(allc[currentE], currentE);
                // 然后设置新的currentS\E

                currentS = pos + 1;
                currentE = currentE + 1;

            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(chars[i])){
                map.put(chars[i],i);
            }else{
                left = Math.max(left,map.get(chars[i])+1);
                map.put(chars[i],i);
            }
            ans = Math.max(ans,i-left+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        leetcode_3 demo = new leetcode_3();
//        demo.lengthOfLongestSubstring("abcabcbb");
    }
}
