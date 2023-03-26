package com.leetcode;

public class leetcode_6354 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        while (k > 0) {
            if (numOnes > 0) {
                int pick = Math.min(k, numOnes);
                sum += pick;
                numOnes -= pick;
                k -= pick;
                continue;
            }
            if (numZeros > 0) {
                int pick = Math.min(k, numZeros);
                k-=pick;
                numZeros-=pick;
                continue;
            }
            if(numNegOnes>0){
                int pick = Math.min(k,numNegOnes);
                k-=pick;
                sum-=pick;
                numNegOnes-=pick;
                continue;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        leetcode_6354 demo = new leetcode_6354();
        demo.kItemsWithMaximumSum(6,6,6,13);
    }
}
