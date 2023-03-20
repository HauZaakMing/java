package com.sword2offer;

import java.util.ArrayList;
import java.util.Collections;

public class q_2 {
    public String addBinary(String a, String b) {


        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int add = 0;
        String ans = "";
        while (p1 >= 0 && p2 >= 0) {
            int cur = add + (charsA[p1] - '0') + (charsB[p2] - '0');
            ans = (cur % 2) + ans;
            add = cur / 2;
            p1--;
            p2--;
        }
        while (p1>=0){
            int cur = add + (charsA[p1] - '0') ;
            ans = (cur % 2) + ans;
            add = cur / 2;
            p1--;
        }
        while (p2>=0){
            int cur = add + (charsB[p2] - '0') ;
            ans = (cur % 2) + ans;
            add = cur / 2;
            p2--;
        }
        if (add != 0) {
            ans = '1' + ans;
        }
        return ans;

    }

    public static void main(String[] args) {
        q_2 demo = new q_2();
        demo.addBinary("1","111");
    }
}
