package com.leetcode;

public class leetcode_88 {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int []nums1copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1copy[i] = nums1[i];
        }
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while(p1<m&&p2<n){
            if(nums1copy[p1]<=nums2[p2]){
                nums1[count++] = nums1copy[p1];
                p1++;
            }else {
                nums1[count++] = nums2[p2];
                p2++;
            }
        }
        while (p1<m){
            nums1[count++] = nums1copy[p1];
            p1++;
        }
        while(p2<n){
            nums1[count++] = nums2[p2];
            p2++;
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int head = m+n-1;
        while(p1>=0&&p2>=0){
            if(nums1[p1]>=nums2[p2]){
                nums1[head--] = nums1[p1];
                p1--;
            }else{
                nums1[head--] = nums2[p2];
                p2--;
            }
        }
        while(p2>=0){
            nums1[head--] = nums2[p2];
            p2--;
        }
    }
}
