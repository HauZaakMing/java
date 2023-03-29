package com.leetcode;

public class leetcode_1092 {


    public String shortestCommonSupersequence(String str1, String str2) {
        //检查一次最长公共子序列
        int len1 = str1.length();
        int len2 = str2.length();

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        //ij为结尾的最长公共子序列长
        int dp[][] = new int[len1+1][len2+1];
        int dirs[][] = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= len2 ; i++) {
            dp[0][i] = 0;
        }
        int curmax = 0;
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j] = 1+dp[i-1][j-1];
                    dirs[i][j] = 0;
                }else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        dp[i][j] = dp[i-1][j];
                        dirs[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i][j-1];
                        dirs[i][j] = 2;
                    }

                }
            }
        }
        int p1 = len1;
        int p2 = len2;
        int temp = dp[len1][len2];
        char ans[] = new char[temp+(len1-temp)+(len2-temp)];
        int pos = ans.length-1;
        while (p1>0&&p2>0){
            if(dirs[p1][p2]==0){
                ans[pos--] = chars1[p1-1];
                p1--;
                p2--;
            }else if (dirs[p1][p2]==1){
                ans[pos--] = chars1[p1-1];
                p1--;
            }else{
                ans[pos--] = chars2[p2-1];
                p2--;
            }
        }
        while (p1>0){
            ans[pos--] = chars1[p1-1];
            p1--;
        }

        while (p2>0){
            ans[pos--] = chars2[p2-1];
            p2--;
        }



//        System.out.println(dp[len1][len2]);
//        String ans = "";
//        p1 = 0;
//        p2 = 0;
//        int cur = 0;
//        while (p1<len1&&p2<len2&&cur<lcs.length()){
//            for (int i = p1; i < len1; i++) {
//                if(chars1[i]==lcs.charAt(cur)){
//                    ans+=str1.substring(p1,i);
//                    p1 = i+1;
//                    break;
//                }
//            }
//            for (int i = p2; i < len2; i++) {
//                if(chars2[i]==lcs.charAt(cur)){
//                    ans+=str2.substring(p2,i);
//                    p2 = i+1;
//                    break;
//                }
//            }
//            ans+=lcs.charAt(cur);
//            cur++;
//        }
//        if(p1<len1){
//            ans+=str1.substring(p1,len1);
//        }
//        if(p2<len2){
//            ans+=str2.substring(p2,len2);
//        }
        return new String(ans);
    }

    public static void main(String[] args) {
        leetcode_1092 demo = new leetcode_1092();
        demo.shortestCommonSupersequence("abac","cab");
    }
}
