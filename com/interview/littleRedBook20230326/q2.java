package com.interview.littleRedBook20230326;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class q2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int []nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            int copy[] = nums.clone();
            Arrays.sort(copy);
            if (check(copy,nums)){
                System.out.println(0);
            }else{
                //先统计左侧匹配部分L1
                int l1 = 0;
                int l2 = 0;
                for (int j = 0; j < n; j++) {
                    if(nums[j]!=copy[j]){
                        l1 = j;
                        break;
                    }
                }

                //若是l1==0，就得从
                //找到L1之后得找L1右边的部分是否出现在数组的末位
                //找到右边的起始
                int rightBegin = copy[l1];
                int rightPos = 0;
                for (int j = l1+1; j < nums.length ; j++) {
                    if(nums[j]!=rightBegin){
                        continue;
                    }else{
                        rightPos = j;
                    }
                }
                boolean flag = true;
                for (int j = 0; j+rightPos < nums.length ; j++) {
                    if(copy[l1+j]!=nums[j+rightPos]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    l2 = nums.length-rightPos;
                }
                int distance = nums.length-l1-l2;
                if(distance%k==0){
                    System.out.println(distance/k);
                }else{
                    System.out.println((distance/k)+1);
                }
            }

        }
    }

    public static boolean check(int []nums,int []target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=target[i]){
                return false;
            }
        }
        return true;
    }
}
