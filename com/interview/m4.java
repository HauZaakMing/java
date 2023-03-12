package com.interview;

import java.util.HashMap;
import java.util.Scanner;

public class m4 {
    public static final int[][] dirs = { {-1,0},{1,0},{0,-1},{0,1} };
    public static void main(String[] args) {
        int matrix[][] = new int[16][16];
        matrix[0][0] = 1;
        matrix[1][1] = 2;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('D', 1);
        map.put('L', 2);
        map.put('R', 3);

        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int length = s1.length();
        int curx1 = 0;
        int cury1 = 0;
        int curx2 = 15;
        int cury2 = 15;
        int curheading1 = 3;
        int curheading2 = 2;
        for (int i = 0; i < length; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (map.containsKey(c1)) {
                int dir = map.get(c1);
                curx1 += dirs[dir][0];
                cury1 += dirs[dir][1];
                matrix[curx1][cury1] = 1;
                curheading1 = dir;
            } else {
                if (curheading1 == 0) {
                    if (curx2 < curx1 && cury1 == cury2) {
                        System.out.println(i + 1);
                    }
                } else if (curheading1 == 1) {
                    if (curx2 > curx1 && cury1 == cury2) {
                        System.out.println(i + 1);
                    }
                } else if (curheading1 == 2) {
                    if (curx2 == curx1 && cury1 > cury2) {
                        System.out.println(i + 1);
                    }
                } else {
                    if (curx2 == curx1 && cury1 < cury2) {
                        System.out.println(i + 1);
                    }
                }
            }
            if (map.containsKey(c2)) {
                int dir = map.get(c2);
                curx2 += dirs[dir][0];
                cury2 += dirs[dir][1];
                matrix[curx2][cury2] = 2;
                curheading2 = dir;
            } else {
                if (curheading2 == 0) {
                    if (curx2 > curx1 && cury1 == cury2) {
                        System.out.println(i + 1);
                    }
                } else if (curheading2 == 1) {
                    if (curx2 < curx1 && cury1 == cury2) {
                        System.out.println(i + 1);
                    }
                } else if (curheading2 == 2) {
                    if (curx2 == curx1 && cury1 < cury2) {
                        System.out.println(i + 1);
                    }
                } else {
                    if (curx2 == curx1 && cury1 > cury2) {
                        System.out.println(i + 1);
                    }
                }


            }

        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if(matrix[i][j]==1){
                    count1++;
                }
            }
        }
    }
}
