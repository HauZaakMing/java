package com.interview.mihayou20230319;

import java.util.Scanner;

public class t3 {
    public static int ans;
    public static void main(String[] args) {

        ans = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums,0,1,0,true);
        System.out.println(ans);
    }

    public static void dfs(int nums[],int pos,int max,int picked,boolean flag){
        if(pos==nums.length+1){
            return;
        }
        //选pos
        if(picked>1&&flag){
            ans++;
            ans = ans %(1000000000+7);
        }
        if(nums[pos]%max==0||max%nums[pos]==0){
            if(nums[pos]>=max){
                dfs(nums,pos+1,nums[pos],picked+1,true);
            }else{
                dfs(nums,pos+1,max,picked+1,true);
            }
        }
        dfs(nums,pos+1,max,picked,false);

    }

}
