package com.leetcode;

import java.util.Arrays;

public class leetcode_33 {

    public int search1(int[] nums, int target) {
        int head = nums[0];
        Arrays.sort(nums);
        //二分找下有没有这个target
        int targetPos = binSearch(nums, 0, nums.length - 1, target);
        if (targetPos == -1) {
            return -1;
        }
        //二分找下head在哪里
        int headPos = binSearch(nums, 0, nums.length - 1, target);
        if (headPos == 0) {
            return targetPos;
        } else {
            if (targetPos == headPos) {
                return 0;
            } else if (targetPos < headPos) {
                return nums.length - headPos + targetPos + 1;
            } else {
                return targetPos - headPos;
            }
        }
    }

    public int binSearch(int[] nums, int l, int r, int target) {
        if (r < l) {
            return -1;
        }
        int mid = (l + r) >> 1;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binSearch(nums, l, mid - 1, target);
        } else {
            return binSearch(nums, mid + 1, r, target);
        }
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            //左有序
            if (nums[l] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {//要不就右有序
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        leetcode_33 demo = new leetcode_33();
        int ans = demo.search(new int[]{3,1},1);
        System.out.println(ans);
    }
}
