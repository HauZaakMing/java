package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class leetcode_1032 {

    //1032. 字符流
    public static void main(String[] args) {
        String []words = new String[5];
        words[0] = "baa";
        words[1] = "ba";
        words[2] = "baba";
        words[3] = "aaaba";
        words[4] = "aaabb";
        StreamChecker streamChecker = new StreamChecker(words);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            char c = sc.next().charAt(0);
            streamChecker.query(c);
        }

    }
}

class StreamChecker1 {
    HashMap<Character, HashSet<String>> map = new HashMap<>();
    String curs;
    int maxLen = 0;
    public StreamChecker(String[] words) {
        curs = "";
        for (int i = 0; i < 26 ; i++) {
            map.put((char)('a'+i),new HashSet<>());
        }
        for (int i = 0; i < words.length; i++) {
            char c = words[i].charAt(words[i].length()-1);
            HashSet<String> set = map.get(c);
            set.add(words[i]);
            maxLen = Math.max(maxLen,words[i].length());
        }
    }

    public boolean query(char letter) {
        curs = curs+letter;
        if(curs.length()>maxLen){
            curs = curs.substring(1);
        }
        if(!map.get(letter).isEmpty()){
            HashSet<String> set = map.get(letter);
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                String target = iterator.next();
                int len = target.length();
                if(curs.length()<len){
                    continue;
                }else{
                    String s = curs.substring(curs.length()-len,curs.length());
                    if(s.equals(target)){
                        return true;
                    }
                }
            }
        }else{
            return false;
        }
        return false;
    }


}

