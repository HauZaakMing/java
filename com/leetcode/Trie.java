package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Trie {

    //这个head是假的head，没有值
    Node head;
    public Trie() {
        this.head = new Node(false,new HashMap<>());
    }

    class Node{


        boolean end;
        HashMap<Character,Node> next = new HashMap<>();

        public Node(boolean end, HashMap<Character, Node> next) {
            this.end = end;
            this.next = next;
        }
    }

    public void insert(String word) {
        if(!search(word)){
            char []chars = word.toCharArray();
            Node p = this.head;
            for (int i = 0; i < chars.length; i++) {
                HashMap<Character,Node> map = p.next;
                if (!map.containsKey(chars[i])){
                    Node node = new Node(false, new HashMap<>());
                    map.put(chars[i],node);
                    p = node;
                }else {
                    p = map.get(chars[i]);

                }

            }
            p.end = true;
        }

    }

    public boolean search(String word) {
        Node p = this.head;

        char []chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(p.next.size()==0){
                return false;
            }
            HashMap<Character,Node> map = p.next;
            if (!map.containsKey(chars[i])){
                return false;
            }else {
                p = map.get(chars[i]);

            }

        }
        if(!p.end){
            return false;
        }
        return true;

    }

    public boolean startsWith(String prefix) {
        Node p = this.head;

        char []chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(p.next.size()==0){
                return false;
            }
            HashMap<Character,Node> map = p.next;
            if (!map.containsKey(chars[i])){
                return false;
            }else {
                p = map.get(chars[i]);

            }

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){

        }
    }
}
