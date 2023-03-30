package com.leetcode;

import java.util.HashMap;

public class leetcode_208 {


}


class Trie {
    TrieNode head;
    int maxHeight;
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
        maxHeight = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int length = word.length();
        if(length>maxHeight){
            maxHeight = length;
        }
        char[] chars = word.toCharArray();
        TrieNode p = head;
        for (int i = 0; i < length; i++) {
            if(p.next[chars[i]-'a']!=null)
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

    }

    class TrieNode{
        TrieNode next[];
        boolean end;

        public TrieNode() {
            next = new TrieNode[26];
            end = false;
        }
    }
}

