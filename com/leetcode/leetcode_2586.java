package com.leetcode;

import java.util.HashSet;

public class leetcode_2586 {

    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Character> yuanyin = new HashSet<>();
        yuanyin.add('a');
        yuanyin.add('e');
        yuanyin.add('i');
        yuanyin.add('o');
        yuanyin.add('u');
        int ans = 0;
        for (int i = left; i <= right; i++) {
            Character head = words[i].charAt(0);
            Character tail = words[i].charAt(words[i].length() - 1);
            if (yuanyin.contains(head) && yuanyin.contains(tail)) {
                ans++;
            }
        }
        return ans;
    }
}
