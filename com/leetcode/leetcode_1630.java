package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class leetcode_1630 {

    //1630. 等差子数组

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int length = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int left = l[i];
            int right = r[i];

            double max = findMax(nums,left,right);
            double min = findMin(nums,left,right);
            if((max-min)%(right-left)!=0){
                ans.add(false);
            }else{
                if(min==max){
                    ans.add(true);
                }else{
                    double step = (int)((max-min)/(right-left));
                    HashSet<Integer> set = new HashSet<>();
                    boolean flag =true;
                    for (int j = left; j <=right ; j++) {
                        if((nums[j]-min)%step!=0){
                            ans.add(false);
                            flag = false;
                            break;
                        }else{
                            int pos = (int) ((nums[j]-min)/step);
                            if(set.contains(pos)){
                                flag =false;
                                ans.add(false);
                                break;
                            }else{
                                set.add(pos);
                            }
                        }
                    }
                    if(flag)ans.add(true);
                }
            }

        }
        return ans;
    }

    public int findMax(int []nums,int left,int right){
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }

    public int findMin(int []nums,int left,int right){
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        leetcode_1630 demo = new leetcode_1630();
        demo.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7},new int[]{0,0,2},new int[]{2,3,5});
    }

}
