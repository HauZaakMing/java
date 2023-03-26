package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_6355 {

    public boolean primeSubOperation(int[] nums) {
        ArrayList<Integer> primes = getPrimeL(1000);
        for (int i = 0; i < nums.length; i++) {
            if(i!=0&&nums[i]<=nums[i-1]){
                return false;
            }
            //找出比当前值小的最大质数
            int pos = -1;
            for (int j = nums[i]-1; j >=2 ; j--) {
                pos = Collections.binarySearch(primes, j);
                if(pos>=0){
                    break;
                }
            }
            //要是没有小于自己的质数就不减了
            if(pos == -1){
                if(i==0){
                    continue;
                }else{
                    if(nums[i]<=nums[i-1]){
                        return false;
                    }else{
                        continue;
                    }
                }
            }
            //要是有比自己小的质数
            //减掉了质数大小就不够,那就不减了
            for (int j = pos; j >= 0 ; j--) {
                if(i==0){
                    nums[i] = nums[i] -primes.get(j);

                    break;
                }else{
                    if(nums[i]-primes.get(j)>nums[i-1]){
                        nums[i] -= primes.get(j);

                        break;
                    }
                }

            }


        }
        return true;
    }

    public static ArrayList<Integer> getPrimeL(int maxN){
        ArrayList<Integer> pl = new ArrayList<>();
        boolean []isprime = new boolean[maxN];
        Arrays.fill(isprime,true);
        isprime[1] = false;
        for (int i = 2; i < maxN; i++) {
            if(isprime[i]){
                pl.add(i);
            }
            for (int j = 0; j < pl.size() && i*pl.get(j)<maxN ; j++) {
                isprime[i*pl.get(j)] = false;
                if(i%pl.get(j)==0) break;
            }

        }
        return pl;
    }


    public static void main(String[] args) {
        leetcode_6355 demo = new leetcode_6355();
        demo.primeSubOperation(new int[]{998,2});
    }
}
