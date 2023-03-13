package com.leetcode;

public class leetcode_2383 {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energySum = 0;
        int curEx = initialExperience;
        int ans = 0;
        for (int i = 0; i < energy.length; i++) {
            energySum += energy[i];
            if(curEx<=experience[i]){
                ans+=(experience[i]-curEx+1);
                curEx = experience[i]*2+1;
            }else{
                curEx = curEx+experience[i];
            }
        }
        if(energySum<initialEnergy){
            return ans;
        }else{
            ans+=energySum+1-initialEnergy;
            return ans;
        }


    }

    public static void main(String[] args) {
        leetcode_2383 demo = new leetcode_2383();
        demo.minNumberOfHours(5,3,new int[]{1,4},new int[]{2,5});
    }
}
