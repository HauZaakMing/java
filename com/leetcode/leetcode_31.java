package com.leetcode;

public class leetcode_31 {
    public void nextPermutation(int[] nums) {
        int p1 = nums.length-2;


        while(p1>=0){
            if(nums[p1]<nums[p1+1]){
                int tempM = Integer.MAX_VALUE;
                int maxp = -1;
                //此时定位p1，然后向后搜索，找比p1位置大的数，找最小的
                int p2 = p1+1;
                while(p2<nums.length){
                    if(nums[p2] > nums[p1] && nums[p2]<tempM){
                        maxp = p2;
                    }
                    p2++;
                }
                swap(nums,p1,maxp);
                reverse(nums,p1+1, nums.length-1);
                break;
            }
            p1--;
        }
        if(p1<0){
            reverse(nums,0, nums.length-1);
        }


    }

    public static void reverse(int []num,int s,int e){
        while(s<e){
            swap(num,s,e);
            s++;
            e--;
        }
    }

    public static void swap(int []num,int p1,int p2){
        num[p1] = num[p1]^num[p2];
        num[p2] = num[p1]^num[p2];
        num[p1] = num[p1]^num[p2];
    }
    public static void main(String[] args) {
        leetcode_31 demo = new leetcode_31();
        demo.nextPermutation(new int[]{1,1,5});
    }
}
