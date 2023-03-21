package com.sword2offer;

public class q_51 {
    //剑指 Offer 51. 数组中的逆序对
    int ans = 0;
    public int reversePairs(int[] nums) {
        merge(nums,0, nums.length-1);
        return ans;
    }

    public void merge(int[] nums,int L,int R){
        if(R<=L){
            return;
        }
        int mid = (L+R)>>1;
        merge(nums,L,mid);
        merge(nums,mid+1,R);
        //左右merge完，开始长的merge
        int p1 = L;
        int p2 = mid+1;
        int []temp = new int[R-L+1];
        int count = 0;

        //大到小
        while (p1<=mid&&p2<=R){
            //左大右小
            if(nums[p1]>nums[p2]){
                ans+=(R-p2+1);
                temp[count] = nums[p1];
                p1++;
            }else{
                temp[count] = nums[p2];
                p2++;
            }
            count++;
        }
        //剩下的都是比较小的
        while (p1<=mid){
            temp[count] = nums[p1];
            count++;
            p1++;

        }
        while(p2<=R){
            temp[count] = nums[p2];
            count++;
            p2++;
        }
        //merge 结束，放回去
        for (int i = L; i <= R ; i++) {
            nums[i] = temp[i-L];
        }
    }

    public static void main(String[] args) {
        q_51 demo = new q_51();
        demo.reversePairs(new int[]{7,5,6,4});
    }

}
