package com.leetcode;

public class leetcode_28 {
    //28. 找出字符串中第一个匹配项的下标
    //kmp算法
    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();

        if(length1<length2){
            return -1;
        }

        //先构建next数组
        int next[] = new int[length2+1];
        next[0] = -1;
        int cur = 1;
        for (int i = 2 ; i < length2+1 ; i++) {
            if(needle.substring(0,0+cur).equals(needle.substring(i-cur,i))){
                next[i] = cur;
                cur++;
            }else{
                while (cur>1){
                    cur--;
                    if(needle.substring(0,0+cur).equals(needle.substring(i-cur,i))){
                        next[i] = cur;
                        cur++;
                        break;
                    }
                }

            }
        }

        int p1 = 0;
        int p2 = 0;
        while(p1<length1){
            if(p2<0){
                p1++;
                p2 = 0;
                continue;
            }
            if(p2 == length2){
                return p1-length2;
            }
            if(haystack.charAt(p1)==needle.charAt(p2)){
                p1++;
                p2++;
            }else {
                p2 = next[p2];
            }
        }
        if(p2 == length2){
            return p1-length2;
        }
        return -1;
    }

    public static void main(String[] args) {
        leetcode_28 demo = new leetcode_28();
        demo.strStr("aabaaabaaac","aabaaac");
    }
}
