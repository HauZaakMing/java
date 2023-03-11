package com.leetcode;

public class leetcode_287 {
    public int findDuplicate(int[] nums) {
        return partition(nums,0,nums.length-1);
    }

    public static int partition(int []nums,int left,int right){
        //我只需要知道第k大，那我只要k前面全小于k，k后面全小于k就好了
        int p1 = left-1;
        int p2 = right+1;
        int target = nums[left];
        int curp = left;
        while(curp<p2){
            if(nums[curp]==target){
                curp++;
            }else if(nums[curp]>target){
                p1 = p1+1;
                swap(nums,p1,curp);
                curp ++;
            }else{
                p2 = p2-1;
                swap(nums,p2,curp);

            }
        }
        if(p2-p1>2){
            return target;
        }else{
            int leftnum = -1;
            int rightnum = -1;
            if(p1>left){
                leftnum = partition(nums,left,p1);
            }
            if(right>p2){
                rightnum = partition(nums,p2,right);
            }

            if(leftnum!=-1){
                return leftnum;
            }
            if(rightnum!=-1){
                return rightnum;
            }
            return -1;
        }
    }

    public static void swap(int []num,int p1,int p2){
        int temp = num[p2];
        num[p2] = num[p1];
        num[p1] = temp;

    }

    public static void main(String[] args) {
        leetcode_287 demo = new leetcode_287();
        System.out.println(demo.findDuplicate(new int[]{3,1,3,4,2}));
    }
}
