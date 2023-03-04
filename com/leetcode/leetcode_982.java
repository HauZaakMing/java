package com.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leetcode_982 {
    public int countTriplets1(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num :
                nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        //取完个数之后就可以去重了
        int []unique = new int[map.size()];
        int cur = -1;
        int count=0;
        for (int num:
            nums) {
            if(num!=cur){
                cur = num;
                unique[count++] = cur;
            }

        }


        for (int i = 0; i < unique.length; i++) {
            for (int j = i; j < unique.length; j++) {
                int temp = unique[i]&unique[j];
                if(temp == 1<<16-1){
                    break;
                }
                for (int k = j; k < unique.length ; k++) {
                    if((unique[k]&temp)==0){
                        int i_num = map.get(unique[i]);
                        int j_num = map.get(unique[j]);
                        int k_num = map.get(unique[k]);
                        if(i==j&i==k){
                            //三个数是一样的
                            ans+= i_num*i_num*i_num;
                        }else if(i==j&&i!=k){
                            //前两个数是一样的
                            ans+=3*k_num*i_num*i_num;
                        }else if(i!=j&&j==k){
                            //后两个数是一样的
                            ans+=3*i_num*j_num*j_num;
                        }else{
                            //三个数都不一样
                            ans+=6*i_num*j_num*k_num;
                        }
                    }
                }



            }
        }

        return ans;
    }

    public int countTriplets(int[] nums) {
        int check[] = new int[1<<16];
        int ans =0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[i]&nums[j];
                check[temp]++;
            }
        }
//        int limit = 1<<16-1;
        for (int i = 0; i < nums.length; i++) {
            int temp = (nums[i])^0xffff;


            for (int sub = temp;sub!=0;sub = (sub-1)&temp){

                ans+=check[sub];

            }
            ans+=check[0];
        }

        return ans;
    }


    public static void main(String[] args) {
        leetcode_982 demo = new leetcode_982();
        int ans = demo.countTriplets(new int[]{2,1,3});
        System.out.println("ans = " + ans);
    }
}
