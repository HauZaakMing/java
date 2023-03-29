package com.leetcode;

public class leetcode_1638 {
    //1638. 统计只差一个字符的子串数目
    public int countSubstrings(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int ans = 0;
        int dp[][][] = new int[s.length()][t.length()][Math.min(s.length(), t.length())];

        //先初始化边缘条件
        //当k==1，比较ij上的字符，不相同则留下1
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (charsS[i] == charsS[j]) {
                    dp[i][j][1] = 1;
                    ans++;
                }
            }
        }
        //开始研究不同的k
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < t.length(); j++) {
//                int maxK = Math.min(i,j)+1;
//                for (int k = 2; k <=maxK ; k++) {
//
//                }
//            }
//        }
//    }
        return 0;
    }
}
