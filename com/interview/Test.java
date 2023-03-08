package com.interview;

import java.util.Arrays;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String s = sc.next();

        int []times = new int[n];
        Arrays.fill(times,1);

        for(int i = 0; i < q; i++){
            int left = sc.nextInt();
            int right = sc.nextInt();
            int add = right-left+1;

            int curright = times[0];
            boolean flag = false;
            for(int j = 0; j < n ;j++){
                if(add <= 0){
                    break;
                }
                int nextright = 0;
                if(j<n-1){
                    nextright = curright+times[j+1];
                }

                if(curright>=left&&!flag){
                    flag =true;
                    int temp = Math.min(add,curright-left+1);
                    times[j]+=temp;
                    add-=temp;
                    continue;
                }
                if(flag){
                    int temp = Math.min(add,times[j]);
                    times[j]+=temp;
                    add-=temp;
                }


                curright = nextright;

            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            while(times[i]>0){
                sb.append(s.charAt(i));
                times[i]--;
            }
        }
        System.out.println(sb.toString());

    }
}
