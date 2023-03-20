package com.sword2offer;

import java.util.regex.Pattern;

public class q_004 {
    public static int ans = 0;
    //剑指 Offer II 004. 只出现一次的数字
    public int singleNumber1(int[] nums) {
        partition(nums,0, nums.length-1);
        return ans;
    }

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num:
                 nums) {
                total+=(num>>i)&1;
            }
            if(total%3!=0){
                ans = ans|(1<<i);
            }
        }

        return ans;
    }

    public void partition(int[] nums,int l, int r){
        int L = l-1;
        int R = r+1;
        int i = l;
        int target = nums[l];
        while(i<R){
            if(nums[i]<target){
                L++;
                swap(nums,L,i);
                i++;
            }else if(nums[i]>target){
                R--;
                swap(nums,R,i);
            }else{
                i++;
            }
        }
        if(R-L-1==1){
            ans = target;
            return ;
        }else{
            if(L>=l&&(L-l+1)%3!=0){
                partition(nums,l,L);
            }else if(r>=R&&(r-R+1)%3!=0){
                partition(nums,R,r);
            }
        }
    }

    public static void swap(int []nums,int p1,int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    public static void main(String[] args) {
        q_004 demo = new q_004();
        demo.singleNumber(new int[]{2,2,3,2});
    }
}
